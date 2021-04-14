package com.dyz.nacos01_7071.bean;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyUtils implements MethodInterceptor {
//
//    public static Object createProxy(Object o, String name) {
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(o.getClass());
//        enhancer.setCallback(new MethodInterceptor() {
//            Object targer = null;
//            String name = null;
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                // 执行具体的代理逻辑
//                System.out.println("===========");
//                Object res = methodProxy.invoke(o, objects);
//                res = res.toString() + name + "重代理";
//                return res;
//            }
//            public MethodInterceptor setparams(Object proxy, String name) {
//                targer = proxy;
//                this.name = name;
//                return this;
//            }
//        }.setparams(o, name));
//        return enhancer.create();
//    }

    public Object getPP(final Object target, String name) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk=================");
                Object res = method.invoke(target, args);
                return res + flag;
            }
            Object targer;
            String flag;
            public InvocationHandler setparams(Object proxy, String name) {
                targer = proxy;
                flag = name;
                return this;
            }
        }.setparams(target, name));
    }
    public Object getProxy(Class cla) {
        System.out.println("getProxy");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cla);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept");

        System.out.println(method.getName() + "没有注解TestProxy");


        Object obj = methodProxy.invokeSuper(o, objects);
        return obj;
    }
}
