package com.dai.en.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AopService2 {

    @Autowired
    AopService aopService;

    public String getName() {
        System.out.println(this);
        return "i am daien";
    }

}
