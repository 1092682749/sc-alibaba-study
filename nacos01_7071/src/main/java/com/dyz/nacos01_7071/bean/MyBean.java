package com.dyz.nacos01_7071.bean;

import com.dyz.nacos01_7071.MyBeanInter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements MyBeanInter {

    public String say() {
        System.out.println("原生方法");
        return "1";
    }
}
