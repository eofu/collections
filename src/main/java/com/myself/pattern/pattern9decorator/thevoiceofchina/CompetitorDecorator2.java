package com.myself.pattern.pattern9decorator.thevoiceofchina;

import com.myself.pattern.pattern9decorator.thevoiceofchina.Competitor;

public class CompetitorDecorator2 extends Competitor {
	public void sing() {
		this.playMusic();
		super.sing();
	}

	private void playMusic() {
		System.out.println("播放背景音乐......");
	}
}
