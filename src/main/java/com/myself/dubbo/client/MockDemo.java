package com.myself.dubbo.client;

import com.myself.dubbo.api.HelloService;

public class MockDemo implements HelloService {
	@Override
	public String syaHello(String str) {
		return "服务繁忙：" + str;
	}
}
