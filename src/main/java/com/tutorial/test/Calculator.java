package com.tutorial.test;

public class Calculator {

    public Integer devide(Integer first, Integer second) {
        if (second == 0) {
            throw new IllegalArgumentException("Can not devide by zero");
        } else {
            return first / second;
        }
    }

    public Integer add(Integer first, Integer second) {
        return first + second;
    }
}
