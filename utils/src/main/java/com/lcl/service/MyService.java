package com.lcl.service;


import org.springframework.stereotype.Service;

@Service
public class MyService implements ServiceInter {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(String msy) {

        System.out.println("MyService say:" + msy);
    }
}

