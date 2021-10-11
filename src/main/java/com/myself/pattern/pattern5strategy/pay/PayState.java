package com.myself.pattern.pattern5strategy.pay;

public class PayState {
    private final int code;
    private final String msg;
    private final Object data;

    public PayState(String msg, Object data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
