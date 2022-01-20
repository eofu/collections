package com.myself.pattern.behavioral.behavioral1strategy.pay.payport;

import com.myself.pattern.behavioral.behavioral1strategy.pay.PayState;

public interface PayMent {
    PayState pay(String userId, Double amout);
}
