package com.myself.dubbo.client;

public class BreakTest {
	public static void main(String[] args) {
		OUT :
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					continue OUT;
				}
				System.out.println(i + "  " + j);
			}
		}
	}
}
