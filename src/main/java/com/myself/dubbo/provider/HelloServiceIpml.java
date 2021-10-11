package com.myself.dubbo.provider;

import com.myself.dubbo.api.HelloService;

public class HelloServiceIpml implements HelloService {
	@Override
	public String syaHello(String str) {
		return "HelloService:" + str;
	}
}
