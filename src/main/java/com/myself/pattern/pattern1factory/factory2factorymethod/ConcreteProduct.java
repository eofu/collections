package com.myself.pattern.pattern1factory.factory2factorymethod;

public class ConcreteProduct extends AbstractProduct {
	@Override
	public void method2() {
		System.out.println(ConcreteProduct.class.getName());
	}
}
