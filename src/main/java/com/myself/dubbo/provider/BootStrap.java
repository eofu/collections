package com.myself.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class BootStrap {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
		context.start();




		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
