package com.github.hcsp.myAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 13:59
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    long value() default 1;
}
