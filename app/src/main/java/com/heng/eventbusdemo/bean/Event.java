package com.heng.eventbusdemo.bean;

/**
 * Created by hengweiyu on 2018/6/13.
 */

public class Event<T> {
    /**
     * 标记码  判断数据来源
     */
    private int tabCode;

    private T data;

    public Event(int tabCode) {
        this.tabCode = tabCode;
    }

    public Event(int tabCode, T data) {
        this.tabCode = tabCode;
        this.data = data;
    }

    public int getTabCode() {
        return tabCode;
    }

    public void setTabCode(int tabCode) {
        this.tabCode = tabCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
