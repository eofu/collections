package com.myself.dubbo.provider;

import com.myself.dubbo.api.HelloService;

public class HelloServiceImpl2 implements HelloService {

	@Override
	public String syaHello(String str) {
		return "Hello version2.0" + str;
	}
}
