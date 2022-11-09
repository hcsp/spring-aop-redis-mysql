package com.github.hcsp.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    // 标记缓存的时长（毫秒），默认 1000ms
    int value() default 1000;
}
