package com.example.demo.hundreddaysofjava.day072;

import jakarta.inject.Named;

@Named("Dog")
class Dog implements Animal {

    private Dog() {
    }

    @Override
    public String speak() {
        return "woof";
    }
}