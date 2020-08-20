package com.github.hcsp.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: YangHuiQuan
 * @Description:
 * @Date: 2020/8/19 20:58
 * @version: 1.0
 * @since: JDK 8
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    int timeout() default 1;
}
