package com.myself.pattern.pattern1factory.factorymethodpattern;

import com.myself.pattern.pattern1factory.factorymethodpattern.AbstractProduct;

public class ConcreteProduct1 extends AbstractProduct {
	@Override
	public void method2() {
		System.out.println(ConcreteProduct1.class.getName());
	}
}
