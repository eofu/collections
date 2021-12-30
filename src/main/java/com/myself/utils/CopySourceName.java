package com.myself.utils;

import java.lang.annotation.*;

/**
 * 拷贝数据用注解
 * @author yangshuai
 */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CopySourceName {
    String value();
}
