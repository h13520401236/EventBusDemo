package com.heng.eventbusdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.heng.eventbusdemo.base.BaseActitvity;
import com.heng.eventbusdemo.bean.Event;
import com.heng.eventbusdemo.bean.EventCode;
import com.heng.eventbusdemo.bean.User;
import com.heng.eventbusdemo.utils.EventBusUtil;

public class SecondActivity extends BaseActitvity {

    private TextView recSticky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recSticky = (TextView) findViewById(R.id.recSticky);
    }

    /**
     * 发送事件是不需要注册的  所以这个方法可有可无，因为默认为false
     *
     * @return
     */
    @Override
    public boolean isRestricted() {
        return false;
    }

    /**
     * 发送事件到MainActivity
     *
     * @param view
     */
    public void sendData(View view) {
        EventBusUtil.sendEvent(new Event<User>(EventCode.A, new User(5, "蜡笔小新")));
        finish();
    }

    private boolean flag;

    /**
     * 点击事件  订阅
     * @param view
     */
    public void recStickyEvent(View view) {
        flag = true;
        if (flag) {
            EventBusUtil.register(this);
        }
    }

    /**
     * 接收MainActivity发送的粘性事件
     * @param event
     */
    @Override
    protected void recStickyEvent(Event event) {
        super.recStickyEvent(event);
        switch (event.getTabCode()) {
            case EventCode.B:
                User user = (User) event.getData();
                recSticky.setText("粘性事件 = " + user.toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flag) {
            EventBusUtil.unRegister(this);
            flag=false;
        }
    }
}
