package com.myself.pattern.pattern1factory.factory3abstractFactory.furniture;

import com.myself.pattern.pattern1factory.factory1simplefactory.Furniture;
import com.myself.pattern.pattern1factory.factory3abstractFactory.furniture.jingdong.JingDongFactory;

/**
 * 要准确识别出当前场景是在构建哪些产品家族的系列产品对象。
 * 每个产品家族的产品系列都要在 AbstractFactory 接口里面定义
 */
public class AbstrackFactoryTest {
    public static void main(String[] args) {
        JingDongFactory jingDongFactory = new JingDongFactory();
        Furniture chair = jingDongFactory.getChair();
    }
}
