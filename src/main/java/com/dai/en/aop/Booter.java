package com.dai.en.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Booter implements CommandLineRunner{

    @Autowired
    AopService aopSerive;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(aopSerive);
        System.out.println(aopSerive.getName("123"));
    }

}
