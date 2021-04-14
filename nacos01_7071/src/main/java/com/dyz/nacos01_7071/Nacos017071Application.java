package com.dyz.nacos01_7071;

//import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dyz.nacos01_7071.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication

public class Nacos017071Application implements CommandLineRunner {
    @Resource
    MyBeanInter myBean;

    @Value("${nacosvalue}")
    String nacosvalue;
    @Value(value = "${pp}")
    String pp;
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    };
    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\classes");
        SpringApplication.run(Nacos017071Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        while (true) {
//            Thread.sleep(5000);
//        }
    }
}
