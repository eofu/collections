package com.myself.pattern.pattern7delegate.leader;

import com.myself.pattern.pattern7delegate.leader.ITarget;

public class TargetA implements ITarget {
    @Override
    public void doing(String commond) {
        System.out.println("A" + commond);
    }
}
