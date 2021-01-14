package com.tutorial.test;

import org.junit.jupiter.api.*;

@DisplayName("information test")
public class InformationTest {

    @Test
    @Tags({
            @Tag("one"),
            @Tag("two"),
    })
    @DisplayName("this is test1")
    void test1(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null)); //optional
        System.out.println(info.getTestMethod().orElse(null)); //optional
    }
}

/*
NOTE:
* anda bisa menambahkan informasi test dengan memasukan TestInfo ke dalam parameter methodnya.
*/