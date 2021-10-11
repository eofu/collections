package com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;
import com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator.CompetitorDecorator;

public class CompetitorDecoratorC extends CompetitorDecorator {

	public CompetitorDecoratorC(Competitor competitor) {
		super(competitor);
	}

	public void sing() {
		this.introduceBGrd();
		super.sing();
	}

	private void introduceBGrd() {
		System.out.println("悲惨世界～～～");
	}

}
