package com.myself.pattern.behavioral.behavioral1strategy.pay.payport;

public enum PayTypeEnum {
    /**
     * 支付方式
     */
    ALI_PAY(new AliPay()), JD_PAY(new JDPay()), WECHAT_PAY(new WeChatPay());
    
    private final com.myself.pattern.behavioral.behavioral1strategy.pay.payport.PayMent payMent;
    
    PayTypeEnum(com.myself.pattern.behavioral.behavioral1strategy.pay.payport.PayMent payMent) {
        this.payMent = payMent;
    }
    
    public PayMent getPayMent() {
        return payMent;
    }
}
