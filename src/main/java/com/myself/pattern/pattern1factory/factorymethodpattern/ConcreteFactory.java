package com.myself.pattern.pattern1factory.factorymethodpattern;

import com.myself.pattern.pattern1factory.factorymethodpattern.AbstractFacotory;
import com.myself.pattern.pattern1factory.factorymethodpattern.AbstractProduct;

public class ConcreteFactory extends AbstractFacotory {
	@Override
	public <T extends com.myself.pattern.pattern1factory.factorymethodpattern.AbstractProduct> T createProduct(Class<T> c) {
		com.myself.pattern.pattern1factory.factorymethodpattern.AbstractProduct product = null;

		try {
			product = (AbstractProduct)Class.forName(c.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return (T)product;
	}
}
