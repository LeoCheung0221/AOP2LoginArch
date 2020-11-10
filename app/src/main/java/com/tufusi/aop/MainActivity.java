package com.tufusi.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tufusi.aop.annotation.ClickBehavior;
import com.tufusi.aop.annotation.LoginCheck;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "====TUFUSI====";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @ClickBehavior("登录")
    public void login(View view) {
        Log.e(TAG, "模拟接口请求……验证通过，登录成功！");
    }

    @ClickBehavior("vip专区")
    @LoginCheck
    public void vip(View view) {
        Log.e(TAG, "开始跳转到 -> vip专区页面");
        startActivity(new Intent(this, OtherBizActivity.class));
    }

    @ClickBehavior("我的优惠券")
    @LoginCheck
    public void coupon(View view) {
        Log.e(TAG, "开始跳转到 -> 我的优惠券页面");
        startActivity(new Intent(this, OtherBizActivity.class));
    }

    @ClickBehavior("我的积分")
    @LoginCheck
    public void score(View view) {
        Log.e(TAG, "开始跳转到 -> 我的积分页面");
        startActivity(new Intent(this, OtherBizActivity.class));
    }
}