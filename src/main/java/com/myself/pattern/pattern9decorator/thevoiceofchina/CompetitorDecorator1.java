package com.myself.pattern.pattern9decorator.thevoiceofchina;

public class CompetitorDecorator1 extends Competitor {
	@Override
    public void sing() {
		this.dance();
		super.sing();
	}

	private void dance() {
		System.out.println("偏偏起舞....");
	}
}
