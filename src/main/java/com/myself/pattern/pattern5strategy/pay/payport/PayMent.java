package com.myself.pattern.pattern5strategy.pay.payport;

import com.myself.pattern.pattern5strategy.pay.PayState;

public interface PayMent {
    PayState pay(String userId, Double amout);
}
