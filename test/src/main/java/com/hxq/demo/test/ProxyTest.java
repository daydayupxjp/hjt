package com.hxq.demo.test;

import com.hxq.demo.entity.Student;
import com.hxq.demo.handler.StuInvocationHandle;
import com.hxq.demo.service.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author hongxq
 * @Date 2019/11/14 0014 16:52
 * @Version 1.0
 **/
public class ProxyTest {

    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandle<>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.giveMoney();
    }

}
