package com.study.koreaItboard.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 런타임에도 유지되어야 함을 의미
@Target({ElementType.METHOD})
public @interface ValidAspect {
}
