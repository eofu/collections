package com.myself.pattern.behavioral.behavioral3delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements ITarget {
    private final Map<String, ITarget> targets = new HashMap<>();

    public Leader() {
        targets.put("登陆", new TargetA());
        targets.put("加密", new TargetB());
    }

    @Override
    public void doing(String commond) {
        targets.get(commond).doing(commond);
    }
}
