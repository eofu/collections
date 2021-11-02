package com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;
import com.myself.pattern.pattern9decorator.thevoiceofchina.afterdecorator.CompetitorDecorator;

public class CompetitorDecoratorB extends CompetitorDecorator {

	public CompetitorDecoratorB(Competitor competitor) {
		super(competitor);
	}

	@Override
    public void sing() {
		this.playMusic();
		super.sing();
	}

	private void playMusic() {
		System.out.println("播放背景音乐～～～");
	}

}
