package com.myself.pattern.structural.structural3decorator.coffee;

/**
 * 装饰着模式：装饰模式是在不必改变原类和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象<br>
 * <p>
 * 使用场景:
 * <br> 1、需要在运行时动态的给一个对象增加额外的职责时候
 * <br>2、需要给一个现有的类增加职责，但是又不想通过继承的方式来实现的时候（应该优先使用组合而非继承），或者通过继承的方式不现实的时候（可能由于排列组合产生类爆炸的问题）。
 * <p>
 * <br>优点:
 * 可以提供比继承更加灵活的方式去扩展对象的功能，通过排列组合，可以对某个类的一些对象做动态的功能扩展，而不需要装饰的对象却可以保持原样。
 * <br>缺点:
 * 仍然是设计模式的通用缺点：类的个数会增加，会产生很多装饰者类，相应的就增加了复杂度。
 * <p>
 * 一般认为代理模式侧重于使用代理类增强被代理对象的访问，而装饰者模式侧重于使用装饰者类来对被装饰对象的功能进行增减。
 * 除了上面的区别，个人实践中还发现，装饰者模式主要是提供一组装饰者类，然后形成一个装饰者栈，来动态的对某一个对象不断加强，而代理一般不会使用多级代理
 */
public class CoffeeTest {
    public static void main(String[] args) {
        ICoffee originalCoffee = new OriginalCoffee();
        originalCoffee.makeCoffee();
        System.out.println();
        
        originalCoffee = new MilkDecorator(originalCoffee);
        originalCoffee.makeCoffee();
        System.out.println();
        
        originalCoffee = new SugarDecorator(originalCoffee);
        originalCoffee.makeCoffee();
    }
}
