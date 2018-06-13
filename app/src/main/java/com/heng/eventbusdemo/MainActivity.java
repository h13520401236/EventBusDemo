package com.heng.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.heng.eventbusdemo.base.BaseActitvity;
import com.heng.eventbusdemo.bean.Event;
import com.heng.eventbusdemo.bean.EventCode;
import com.heng.eventbusdemo.bean.User;
import com.heng.eventbusdemo.utils.EventBusUtil;

public class MainActivity extends BaseActitvity implements View.OnClickListener {

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = (TextView) findViewById(R.id.tv_showText);
        findViewById(R.id.frist).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
    }

    /**
     *
     * @return true  注册EventBus
     */
    @Override
    protected boolean isRegEventBus() {
        return true;
    }

    /**
     * 接收secondActivity中发送过来的事件
     *
     * @param event
     */
    @Override
    protected void recEvent(Event event) {
        super.recEvent(event);
        //event.getTabCode() 判断数据的来源
        switch (event.getTabCode()) {
            case EventCode.A:
                User user = (User) event.getData();
                tvShow.setText("age=" + user.age + ",name = " + user.name);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //跳转到secondAc 在secondAc中发送事件
            case R.id.frist:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            //发送粘性事件到SecondActivity中
            case R.id.second:
                EventBusUtil.sendStickyEvent(new Event<User>(EventCode.B, new User(40, "武庚")));
                startActivity(new Intent(this, SecondActivity.class));
                break;
        }
    }
}
