package com.myself.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	private volatile Test test;

	private Test() {

	}

	public Test getTestInstance() {
		if (test == null) {
			synchronized (this) {
				if (test == null) {
					test = new Test();
				}
			}
		}
		return test;
	}
}
