package com.myself.pattern.pattern7delegate.leader;

import com.myself.pattern.pattern7delegate.leader.ITarget;

public class TargetB implements ITarget {
    @Override
    public void doing(String commond) {
        System.out.println("B" + commond);
    }
}

