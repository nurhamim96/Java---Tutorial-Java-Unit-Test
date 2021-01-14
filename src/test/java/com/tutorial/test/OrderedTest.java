package com.tutorial.test;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class) // di urutkan berdasarkan nama methodnya
//@TestMethodOrder(MethodOrderer.Random.class) // acak
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTest {

    private int counter = 0;

    @BeforeAll
    void beforeAll() {}

    @AfterAll
    void afterAll() {}

    @Test
    @Order(1)
    void test3() {

        // PER METHOD
//        OrderedTest test3 = new OrderedTest();
//        test3.test3();
//
//        OrderedTest test2 = new OrderedTest();
//        test2.test2();
//
//        OrderedTest test1 = new OrderedTest();
//        test1.test1();

        // PER CLASS
//        OrderedTest test = new OrderedTest();
//        test.test3();
//        test.test2();
//        test.test1();

        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}

/*
NOTE :
* ketika menggunakan @TestMethodOrder(MethodOrderer.OrderAnnotation.class) tambahkan juga @Order() dan masukkan urutan method yang akan di eksekusi ke dalam parameternya.
* @TestInstance(TestInstance.Lifecycle.PER_METHOD) ini default lifecyclenya.
* keuntungan menggunakan @TestInstance(TestInstance.Lifecycle.PER_CLASS) kita bisa menggunakan annotation @BeforeAll dan @AfterAll di method biasa (tidak perlu menggunakan method static).
* */