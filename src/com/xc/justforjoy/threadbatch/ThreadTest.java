package com.xc.justforjoy.threadbatch;

import com.xc.justforjoy.threadbatch.entity.User;
import com.xc.justforjoy.threadbatch.thread.UserThread;
import com.xc.justforjoy.threadbatch.util.ListUtil;

import java.util.List;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
public class ThreadTest {

    public static void main(String[] args) {
        // 1.初始化用户数据
        List<User> listUser = UserThread.init();
        // 2.计算创建创建多少个线程并且每一个线程需要执行“分批发送短信用户”
        // 每一个线程分批跑多少
        int userThreadPage = 50;
        // 计算所有线程数
        List<List<User>> splitUserList = ListUtil.splitList(listUser, userThreadPage);
        int threadSize = splitUserList.size();
        for (int i = 0; i < threadSize; i++) {
            List<User> list = splitUserList.get(i);
            UserThread userThread = new UserThread(list);
            // 3.执行任务发送短信
            userThread.start();
        }
    }

}
