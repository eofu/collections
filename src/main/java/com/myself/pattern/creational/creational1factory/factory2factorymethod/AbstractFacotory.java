package com.myself.pattern.creational.creational1factory.factory2factorymethod;

public abstract class AbstractFacotory {
	public abstract <T extends AbstractProduct> T createProduct(Class<T> c);
}
