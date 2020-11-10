package com.tufusi.aop.aspect;

import android.util.Log;

import com.tufusi.aop.annotation.ClickBehavior;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by LeoCheung on 2020/11/10.
 *
 * @description
 */
@Aspect
public class ClickBehaviorAspect {

    private static final String TAG = "====TUFUSI====";

    @Pointcut("execution(@com.tufusi.aop.annotation.ClickBehavior **(..))")
    public void clickPointCut() {
    }

    @Around("clickPointCut()")
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取签名方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // 获取方法所属的类名
        String className = methodSignature.getDeclaringType().getSimpleName();

        // 获取方法名
        String methodName = methodSignature.getName();

        // 获取方法的注解值
        String injectName = methodSignature.getMethod().getAnnotation(ClickBehavior.class).value();

        long begin = System.currentTimeMillis();
        Log.e(TAG, "ClickBehavior Method Start >>>");
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - begin;
        Log.e(TAG, "ClickBehavior Method End >>>");
        Log.e(TAG, String.format("统计了：%s功能，在%s类的%s方法，耗时%d ms", injectName, className, methodName, duration));

        return result;
    }

} 