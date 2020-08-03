package com.xc.justforjoy.threadbatch.thread;

import com.xc.justforjoy.threadbatch.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class UserThread extends Thread {

    private List<User> list = null;

    /**
     * 通过构造函数 传入每个线程需要执行的发送短信内容
     *
     * @param list
     */
    public UserThread(List<User> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (User user : list) {
            System.out.println("threadName:" + Thread.currentThread().getName() + "   学员编号：" + user.getUserId()
                    + "   学员名称：" + user.getUserName());
            //调用发送短信具体代码

        }
    }

    /**
     * 初始化数据
     *
     * @return
     */
    public static List<User> init() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            User user = new User();
            user.setUserId("userId = " + i);
            user.setUserName("userName = " + i);
            list.add(user);
        }
        return list;
    }

}
