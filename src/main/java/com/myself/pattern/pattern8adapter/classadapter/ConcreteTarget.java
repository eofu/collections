package com.myself.pattern.pattern8adapter.classadapter;

import com.myself.pattern.pattern8adapter.classadapter.Target;

public class ConcreteTarget implements Target {
	@Override
	public void request() {
		System.out.println("concreteTarget目标方法");
	}
}
