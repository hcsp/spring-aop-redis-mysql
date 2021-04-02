package com.github.hcsp.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * @return 返回缓存有效期秒数，默认 1 秒有效期
     */
    int value() default 1;
}
