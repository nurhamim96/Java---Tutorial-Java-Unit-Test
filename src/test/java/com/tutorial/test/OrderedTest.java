package com.tutorial.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.MethodName.class) // di urutkan berdasarkan nama methodnya
//@TestMethodOrder(MethodOrderer.Random.class) // acak
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Test
    @Order(1)
    void test3() {

    }

    @Test
    @Order(2)
    void test2() {

    }

    @Test
    @Order(3)
    void test1() {

    }
}

/*
NOTE :
* ketika menggunakan @TestMethodOrder(MethodOrderer.OrderAnnotation.class) tambahkan juga @Order() dan masukkan urutan method yang akan di eksekusi ke dalam parameternya.
* */