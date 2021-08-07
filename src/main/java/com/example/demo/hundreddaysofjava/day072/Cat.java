package com.example.demo.hundreddaysofjava.day072;

import jakarta.inject.Named;

@Named("Cat")
class Cat implements Animal {

    private Cat(){
    }

    @Override
    public String speak() {
        return "meow";
    }
}