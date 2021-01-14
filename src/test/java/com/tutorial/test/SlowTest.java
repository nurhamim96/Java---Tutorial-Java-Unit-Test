package com.tutorial.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow() throws InterruptedException {
        Thread.sleep(10_000); // test nya akan gagal karena lebih dari 5 detik
    }
}

/*
 NOTE :
* Gunaka annotation @TimeOut untuk memastikan unit test berjalan tidak lebih dari waktu yang telah ditentukan
 */