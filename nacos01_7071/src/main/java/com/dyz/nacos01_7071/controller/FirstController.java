package com.dyz.nacos01_7071.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
@RefreshScope
public class FirstController {
    @Value("${nacosvalue}")
    String nacosvalue;
    @Value(value = "${pp}")
    String pp;
    @Value("${useLocalCache:true}")
    private boolean useLocalCache;

   @Autowired
   RestTemplate restTemplate;

    @RequestMapping("/get")
    public String get() {
        return nacosvalue;
    }

    @RequestMapping("/call")
    public String call() {
        return restTemplate.getForObject("http://example2/nas02/methode", String.class);
    }
}
