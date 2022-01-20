package com.myself.pattern.behavioral.behavioral3delegate.leader;

public class TargetB implements ITarget {
    @Override
    public void doing(String commond) {
        System.out.println("B" + commond);
    }
}

