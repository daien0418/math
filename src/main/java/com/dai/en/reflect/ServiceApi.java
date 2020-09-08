package com.dai.en.reflect;

public interface ServiceApi {

    @Mine(value = "cat")
    String getName();

    int getAge();

}
