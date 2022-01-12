package com.myself.pattern.pattern4proxy.dynamicproxy.jdk;

/**
 * <br>使用方法：
 * <br>1、代理类实现invocationhandler接口，并实现invoke方法，代理的内容写在invoke方法中。
 * <br>2、通过Proxy.newProxyInstance传入被代理对象的类加载器，接口和invocationhandler。
 * <p>动态代理的原理：通过反射生成被代理类的对象，对象中包括了被代理类的所有方法。调用被代理类的对象中的方法时，返回的是invoke方法，从而实现类的动态代理。
 */
public class JDKProxyTest {
    public static void main(String[] args) throws Exception {
        
        // Person person = (Person) new Sf().getInstance(new Programmer());
        // person.shopping();
        
        // 这个对象不是我写的对象，是通过反射生成的对象，所有方法的调用都会被转发到与这个代理对象关联的InvocationHandler对象的invoke()方法中去。
        Person instance = (Person) new Eleme().getInstance(new Programmer());
        instance.dinner();
        
        // byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        // FileOutputStream fileOutputStream = new FileOutputStream("/Users/yangshuai/Desktop/$Proxy0.class");
        // fileOutputStream.write($Proxy0s);
        // fileOutputStream.close();
    }
}
