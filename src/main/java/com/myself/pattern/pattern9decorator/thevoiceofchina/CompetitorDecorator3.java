package com.myself.pattern.pattern9decorator.thevoiceofchina;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;

public class CompetitorDecorator3 extends Competitor {
	public void sing() {
		super.sing();
		this.introduceBackground();
	}

	private void introduceBackground() {
		System.out.println("悲惨背景介绍，博取同情，赢感情牌....");
	}
}
