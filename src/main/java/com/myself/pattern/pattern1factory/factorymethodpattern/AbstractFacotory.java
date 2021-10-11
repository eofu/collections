package com.myself.pattern.pattern1factory.factorymethodpattern;

import com.myself.pattern.pattern1factory.factorymethodpattern.AbstractProduct;

public abstract class AbstractFacotory {
	public abstract <T extends AbstractProduct> T createProduct(Class<T> c);
}
