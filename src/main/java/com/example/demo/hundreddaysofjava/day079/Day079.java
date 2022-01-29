package com.example.demo.hundreddaysofjava.day079;

public class Day079 {

    public static void main(String[] args) {
        // This class has access to MyService and MyServiceFactory, but not MyServiceImpl
        MyService myService = MyServiceFactory.createMyService();
        myService.run();
    }
}
