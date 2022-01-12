package com.myself.pattern.pattern8adapter.passport;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultMSG {
    private String code;
    private String msg;
    private Object data;
}
