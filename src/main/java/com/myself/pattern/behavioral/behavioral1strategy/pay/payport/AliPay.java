package com.myself.pattern.behavioral.behavioral1strategy.pay.payport;

import com.myself.pattern.behavioral.behavioral1strategy.pay.PayState;

public class AliPay implements PayMent {

    @Override
    public PayState pay(String userId, Double amout) {
        System.out.println("选择支付宝：");
        return new PayState("支付成功", amout, 200);
    }
}
