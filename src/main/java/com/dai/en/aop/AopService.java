package com.dai.en.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AopService {

    @Autowired
    AopService2 aopService2;

    @Transactional
    public String getName(String arg) {
        System.out.println(this);
        if(arg.equals("123")){
            throw new RuntimeException();
        }
        return "i am dai";
    }

}
