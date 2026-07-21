package com.ana.demo.service;


import org.springframework.stereotype.Service;

@Service
public class HelloWordService {

    public String helloWord(String name) {
        return "Hello, " + name + "!";
    }
}
