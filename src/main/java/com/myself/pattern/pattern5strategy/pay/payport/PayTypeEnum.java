package com.myself.pattern.pattern5strategy.pay.payport;

import com.myself.pattern.pattern5strategy.pay.payport.AliPay;
import com.myself.pattern.pattern5strategy.pay.payport.JDPay;
import com.myself.pattern.pattern5strategy.pay.payport.PayMent;
import com.myself.pattern.pattern5strategy.pay.payport.WeChatPay;

public enum PayTypeEnum {
    ALI_PAY(new AliPay()), JD_PAY(new JDPay()), WECHAT_PAY(new WeChatPay());

    private final com.myself.pattern.pattern5strategy.pay.payport.PayMent payMent;

    PayTypeEnum(com.myself.pattern.pattern5strategy.pay.payport.PayMent payMent) {
        this.payMent = payMent;
    }

    public PayMent getPayMent() {
        return payMent;
    }
}
