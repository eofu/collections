package com.myself.pattern.behavioral.behavioral1strategy.traficselect;

/**
 * 优点：降低了算法类的职责，使各个算法可以独立变化并互相替换。而且使得增加新的算法变的很容易，降低了对原有系统的侵入，最终使得程序可扩展可维护性增强。
 * 缺点：所有设计模式的通病，类增多了，程序从局部来看变的更复杂了。
 */
public class TrafficSelectTest {
    public static void main(String[] args) {
        TrafficFeeCalculator calculator = new TrafficFeeCalculator();
        System.out.println(String.format(
                "乘坐公交车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new ByBus(), 10)
        ));
        System.out.println(String.format(
                "乘坐滴滴快车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new ByDiDiExpress(), 10)
        ));
        System.out.println(String.format(
                "骑共享单车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new BySharedBicycle(), 10)
        ));
    }
}
