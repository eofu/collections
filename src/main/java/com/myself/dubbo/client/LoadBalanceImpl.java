package com.myself.dubbo.client;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

public class LoadBalanceImpl implements LoadBalance {
	@Override
	public <T> Invoker<T> select(List<Invoker<T>> var1, URL var2, Invocation var3) throws RpcException {
		System.out.println("using my loadBalance");
		return var1.get(0);
	}
}
