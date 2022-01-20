package com.myself.pattern.structural.structural2adapter.passport;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultMSG {
    private String code;
    private String msg;
    private Object data;
}
