package com.github.hcsp.cache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author qiaomengnan
 * @ClassName: Cache
 * @Description:
 * @date 2020-08-30
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {

    int value() default 1;

}
