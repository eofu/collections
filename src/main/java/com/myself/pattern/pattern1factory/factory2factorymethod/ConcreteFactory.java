package com.myself.pattern.pattern1factory.factory2factorymethod;

import java.lang.reflect.InvocationTargetException;

public class ConcreteFactory extends AbstractFacotory {
    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> c) {
        AbstractProduct product = null;
		
        try {
            product = (AbstractProduct) Class.forName(c.getName()).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
	
	    return (T) product;
    }
}
