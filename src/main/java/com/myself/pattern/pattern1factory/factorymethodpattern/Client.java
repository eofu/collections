package com.myself.pattern.pattern1factory.factorymethodpattern;

import com.myself.pattern.pattern1factory.factorymethodpattern.ConcreteFactory;
import com.myself.pattern.pattern1factory.factorymethodpattern.ConcreteProduct1;

public class Client {
	public static void main(String[] args) {
		ConcreteFactory concreteFactory = new ConcreteFactory();
		ConcreteProduct1 product = concreteFactory.createProduct(ConcreteProduct1.class);
		product.method2();
	}
}
