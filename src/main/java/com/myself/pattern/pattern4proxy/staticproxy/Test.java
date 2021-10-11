package com.myself.pattern.pattern4proxy.staticproxy;

import com.myself.pattern.pattern4proxy.staticproxy.Student;
import com.myself.pattern.pattern4proxy.staticproxy.YellowMoww;

/**
 * 起到类服务中介作用。
 * 为什么用到代理模式：
 * 在不破坏原有业务处理边界的前提下，增加额外的定制需求。如：有1、2、3、三个串行任务，在业务2前后增加非关键额外业务。
 */
public class Test {
	public static void main(String[] args) {
		Student student = new Student();
		new YellowMoww().replaceBuyTicket(student);
	}
}
