package com.dyz.nacos01_7071.bean;

import com.dyz.nacos01_7071.MyBeanInter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(2147483645)
public class BeanProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext applicationContext;
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(applicationContext.getApplicationName());
//        AnnotationConfigServletWebApplicationContext
        if (bean instanceof MyBeanInter) {
//            bean = MyProxyUtils.createProxy(bean, "代理");
        MyProxyUtils myProxyUtils = new MyProxyUtils();
            bean = myProxyUtils.getPP(bean, "2222222222");
        }

        return bean;
    }


}
