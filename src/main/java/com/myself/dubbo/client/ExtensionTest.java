package com.myself.dubbo.client;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

public class ExtensionTest {
	public static void main(String[] args) {
		ExtensionLoader<LoadBalance> extensionLoader = ExtensionLoader.getExtensionLoader(LoadBalance.class);

		LoadBalance balance = extensionLoader.getAdaptiveExtension();
		LoadBalance loadBalance = extensionLoader.getExtension("true");
 
		System.out.println(balance);
		System.out.println(loadBalance);
	}
}
