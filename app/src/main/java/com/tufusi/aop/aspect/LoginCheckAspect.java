package com.tufusi.aop.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.tufusi.aop.LoginActivity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by LeoCheung on 2020/11/10.
 *
 * @description
 */
@Aspect
public class LoginCheckAspect {

    private static final String TAG = "====TUFUSI====";

    @Pointcut("execution(@com.tufusi.aop.annotation.LoginCheck **(..))")
    public void clickPointCut() {
    }

    @Around("clickPointCut()")
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getThis();
        boolean isLogin = false;
        if (isLogin) {
            Log.e(TAG, "已登录----");
            return joinPoint.proceed();
        } else {
            Log.e(TAG, "未登录----");
            Toast.makeText(context, "请先登录", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return null;
        }
    }
} 