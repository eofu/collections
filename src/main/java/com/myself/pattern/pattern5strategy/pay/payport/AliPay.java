package com.myself.pattern.pattern5strategy.pay.payport;

import com.myself.pattern.pattern5strategy.pay.PayState;
import com.myself.pattern.pattern5strategy.pay.payport.PayMent;

public class AliPay implements PayMent {

    public PayState pay(String userId, Double amout) {
        System.out.println("选择支付宝：");
        return new PayState("支付成功", amout, 200);
    }
}
