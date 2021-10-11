package com.myself.pattern.pattern9decorator;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;
import com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator.*;

public class Client {
	public static void main(String[] args) {
		Competitor competitor = new Competitor();

		CompetitorDecorator decorator = new CompetitorDecorator(competitor);
		decorator = new CompetitorDecoratorA(decorator);
		decorator = new CompetitorDecoratorB(decorator);
		decorator = new CompetitorDecoratorC(decorator);
		decorator.sing();
	}
}
