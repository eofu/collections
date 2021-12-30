package com.myself.utils;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * SnowFlake的结构如下<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是整数，最高位是0 <br>
 * 41位时间戳（毫秒级），41位时间戳不是储存当前时间的时间戳，而是储存时间戳的差值（当前时间戳 - 开始时间戳得到的值），开始时间戳一般是id生成器开始使用的时间，由程序来指定。41位的时间戳，可以使用69年，年T = (1L<<41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的位数顺序号支持每个节点每毫秒（同一机器，同一时间戳）产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞（由数据中心ID和机器ID区分），并且效率较高，SnowFlake每秒能产生26万Id左右
 */
public class SnowFlakeIdWorker {

    private static final SnowFlakeIdWorker ID_WORKER;

    static {
        ID_WORKER = new SnowFlakeIdWorker(getWorkId(), getDataCenterId());
    }

    /**
     * 开始时间戳（2015-01-01）
     */
    private final long twepoch = 1489111610226L;
    /**
     * 机器id所占的位数
     */
    private final long workerIdBits = 5L;
    /**
     * 数据标识id所占的位数
     */
    private final long dataCenterIdBidts = 5L;
    /**
     * 支持的最大机器id，结果是31（这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数）
     */
    private final long maxWorkerId = ~(-1L << workerIdBits);
    /**
     * 支持的最大数据标识id，结果是31
     */
    private final long maxDataCenterId = ~(-1L << dataCenterIdBidts);
    /**
     * 序列在id中所占的位数
     */
    private final long sequenceBits = 12L;
    /**
     * 机器ID向左移12位
     */
    private final long workerIdShift = sequenceBits;
    /**
     * 数据标识id向左移17位（12+5）
     */
    private final long dataCenterIdShift = sequenceBits + workerIdBits;
    /**
     * 时间戳向左移22位（5+5+12）
     */
    private final long timeStampLeftShift = sequenceBits + workerIdBits + dataCenterIdBidts;
    /**
     * 生成序列的掩码，这里位4095（0b111111111111=0xfff=4095）
     */
    private final long sequenceMask = ~(-1L << sequenceBits);
    /**
     * 工作机器ID（0~31）
     */
    private final long workerId;
    /**
     * 数据中心ID（0~31）
     */
    private final long dataCenterId;
    /**
     * 上次生成ID的时间戳
     */
    private long lastTimeStamp = -1L;
    /**
     * 毫秒内序列（0~4095）
     */
    private long sequence = 0L;

    public SnowFlakeIdWorker(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerId can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenterId can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    private static Long getWorkId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int b : ints) {
                sums += b;
            }
            return (long) (sums % 32);
        } catch (UnknownHostException e) {
            // 获取失败使用随机数
            return RandomUtils.nextLong(0, 31);
        }
    }

    private static Long getDataCenterId() {
        int[] ints = StringUtils.toCodePoints(SystemUtils.getHostName());
        int sums = 0;
        for (int i : ints) {
            sums += i;
        }
        return (long) (sums % 32);
    }

    public static synchronized Long generateId() {
        return ID_WORKER.nextId();
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimeStamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d millisenconds", lastTimeStamp));
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimeStamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMills(lastTimeStamp);
            }
        } else {
            sequence = 0L;
        }

        // 上次生成ID的时间戳
        lastTimeStamp = timestamp;

        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timeStampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimeStamp 上次生成Id的时间戳
     * @return 当前时间戳
     */
    protected long tilNextMills(long lastTimeStamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimeStamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒位单位的当前时间
     *
     * @return 当前时间（毫秒）
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
