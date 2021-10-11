package com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;

public class CompetitorDecorator extends Competitor {
	private final Competitor competitor;

	public CompetitorDecorator(Competitor competitor) {
		this.competitor = competitor;
	}

	public void sing() {
		competitor.sing();
	}
}
