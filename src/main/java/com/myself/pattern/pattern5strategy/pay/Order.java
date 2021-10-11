package com.myself.pattern.pattern5strategy.pay;

import com.myself.pattern.pattern5strategy.pay.PayState;
import com.myself.pattern.pattern5strategy.pay.payport.PayTypeEnum;

public class Order {
    private final String orderId;
    private final String userId;
    private final Double amout;

    public Order(String orderId, String userId, Double amout) {
        this.orderId = orderId;
        this.userId = userId;
        this.amout = amout;
    }

    public PayState pay(PayTypeEnum payTypeEnum) {
        return payTypeEnum.getPayMent().pay(this.userId, this.amout);
    }
}
