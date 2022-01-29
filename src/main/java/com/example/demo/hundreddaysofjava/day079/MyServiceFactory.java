package com.example.demo.hundreddaysofjava.day079;

public class MyServiceFactory {

    private MyServiceFactory() {
    }

    public static MyService createMyService() {
        return new MyServiceImpl();
    }

}
