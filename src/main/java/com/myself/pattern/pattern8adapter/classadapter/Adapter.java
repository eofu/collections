package com.myself.pattern.pattern8adapter.classadapter;

import com.myself.pattern.pattern8adapter.classadapter.Adaptee;
import com.myself.pattern.pattern8adapter.classadapter.Target;

// 类适配器
public class Adapter extends Adaptee implements Target {
	@Override
	public void request() {
		super.adapteeRequest();
	}
}
