package com.myself.pattern.creational.creational1factory.factory2factorymethod;

/**
 * 优点：不直接在客户端创建具体产品的实例，降低了耦合性。
 * 缺点：每增加一种产品就要相应的增加一个工厂类，比较繁琐。
 */
public class Client {
	public static void main(String[] args) {
		ConcreteFactory concreteFactory = new ConcreteFactory();
		ConcreteProduct product = concreteFactory.createProduct(ConcreteProduct.class);
		product.method2();
	}
}
