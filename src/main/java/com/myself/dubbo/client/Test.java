package com.myself.dubbo.client;

import com.myself.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
		HelloService helloService = (HelloService)context.getBean("helloService");
		String dubbo = helloService.syaHello("dubbo");
		System.out.println(dubbo);
	}
}
