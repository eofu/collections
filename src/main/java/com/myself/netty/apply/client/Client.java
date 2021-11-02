package com.myself.netty.apply.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final int MAX_RETRY = 5;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                });
        connect(bootstrap, "127.0.0.1", 8899, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("connect");
            } else if (retry == 0) {
                System.err.println("retry count is using up, stop connect");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 << order;
                System.err.println(new Date() + ":connect false," + order + "......");
                bootstrap
                        // 返回 BootstrapConfig，对 Bootstrap 配置参数的抽象
                        .config()
                        // 返回的是配置的线程模型 workerGroup
                        .group()
                        // 实现定时任务逻辑
                        .schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }
}
