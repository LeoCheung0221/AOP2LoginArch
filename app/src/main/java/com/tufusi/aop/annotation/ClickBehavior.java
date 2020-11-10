package com.tufusi.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by LeoCheung on 2020/11/10.
 *
 * @description 用户行为统计
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClickBehavior {

    /**
     * 注解模块名称
     *
     * @return 返回名称
     */
    String value();
}
