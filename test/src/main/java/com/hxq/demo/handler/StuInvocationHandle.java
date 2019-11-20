package com.hxq.demo.handler;

import com.hxq.demo.util.MonitorUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName StuInvocationHandle
 * @Description 代理类
 * @Author hongxq
 * @Date 2019/11/14 16:41
 * @Version 1.0
 **/
public class StuInvocationHandle<T> implements InvocationHandler {

    private T target;

    public StuInvocationHandle(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" +method.getName() + "方法");
        MonitorUtil.start();
        Object object = method.invoke(target,args);
        MonitorUtil.finish(method.getName());
        return object;
    }


}
