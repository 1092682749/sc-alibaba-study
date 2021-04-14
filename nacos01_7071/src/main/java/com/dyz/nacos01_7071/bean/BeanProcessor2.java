package com.dyz.nacos01_7071.bean;

import com.dyz.nacos01_7071.MyBeanInter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Order(2147483646)
public class BeanProcessor2 implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBeanInter) {
//            bean = MyProxyUtils.createProxy(bean, "代理2");
//
            System.out.println("333333");
            MyProxyUtils myProxyUtils = new MyProxyUtils();
            bean = myProxyUtils.getPP(bean, "33333333333333");
            System.out.println(((MyBeanInter) bean).say());
        }


        return bean;
    }


}
