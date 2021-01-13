package com.tutorial.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String temp;

    @Test
    public void testA() {
        // walaupun udah di set, ketika digunakan di method lain hasilnya pasti null. Karena di unit tes lifecyclenya independent antar method
        temp = "Ibad";
    }

    @Test
    public void testB() {
        System.out.println(temp);
    }
}

/*
* Di unit tes lifecycle nya independent antar method.
* */