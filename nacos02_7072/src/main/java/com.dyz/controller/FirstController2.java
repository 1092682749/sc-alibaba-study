package com.dyz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nas02")
public class FirstController2 {
    @RequestMapping("/method")
    public String method() {
        return "aaaaaaaa";
    }
}
