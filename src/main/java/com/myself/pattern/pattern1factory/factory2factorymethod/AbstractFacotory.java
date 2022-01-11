package com.myself.pattern.pattern1factory.factory2factorymethod;

public abstract class AbstractFacotory {
	public abstract <T extends AbstractProduct> T createProduct(Class<T> c);
}
