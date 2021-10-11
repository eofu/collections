package com.myself.pattern.pattern8adapter.classadapter;

import com.myself.pattern.pattern8adapter.classadapter.Adapter;
import com.myself.pattern.pattern8adapter.classadapter.ConcreteTarget;

public class Test {
	public static void main(String[] args) {
		new ConcreteTarget().request();
		new Adapter().request();
		new com.myself.pattern.pattern8adapter.objectadapter.Adapter().request();
	}
}
