package com.heng.eventbusdemo.utils;

import com.heng.eventbusdemo.bean.Event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by hengweiyu on 2018/6/13.
 */

public class EventBusUtil {
    /**
     * 注册EventBus
     *
     * @param subscriber
     */
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 取消注册
     *
     * @param subscriber
     */
    public static void unRegister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发送事件
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘性事件
     *
     * @param event
     */
    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }
}
