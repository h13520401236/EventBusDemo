package com.heng.eventbusdemo.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heng.eventbusdemo.bean.Event;
import com.heng.eventbusdemo.utils.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseActitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        if (isRegEventBus()) {
            EventBusUtil.register(this);
        }
    }

    /**
     * 子类中是否需要注册 默认 false 不需要注册
     * 如若需要子类实现 isRegEventBus() 方法 返回值改为true
     *
     * @return
     */
    protected boolean isRegEventBus() {
        return false;
    }

    /**
     * 接受 发送事件
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(Event event) {
        if (event != null) {
            recEvent(event);
        }
    }

    /**
     * 子类实现  接受事件方法
     *
     * @param event
     */
    protected void recEvent(Event event) {

    }

    /**
     * 接受粘性事件 方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBus(Event event) {
        if (event != null) {
            recStickyEvent(event);
        }
    }

    /**
     * 子类实现  接受粘性事件方法
     *
     * @param event
     */
    protected void recStickyEvent(Event event) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        if (isRegEventBus()) {
            EventBusUtil.unRegister(this);
        }
    }
}
