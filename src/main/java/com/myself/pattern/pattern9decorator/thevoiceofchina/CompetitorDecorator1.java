package com.myself.pattern.pattern9decorator.thevoiceofchina;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;

public class CompetitorDecorator1 extends Competitor {
	public void sing() {
		this.dance();
		super.sing();
	}

	private void dance() {
		System.out.println("偏偏起舞....");
	}
}
