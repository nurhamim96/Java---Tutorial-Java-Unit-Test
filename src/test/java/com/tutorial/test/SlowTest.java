package com.tutorial.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class SlowTest {

    // Jika tidak dijalankan secara parallel ketiga test dibawah akan memakan waktu 12 detik.
    // Sedangkan kalo dijalankan secara parallel ketiga test dibawah hanya memakan waktu 4 detik saja.

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow1() throws InterruptedException {
//        Thread.sleep(10_000); // test nya akan gagal karena lebih dari 5 detik
        Thread.sleep(4_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow2() throws InterruptedException {
//        Thread.sleep(10_000); // test nya akan gagal karena lebih dari 5 detik
        Thread.sleep(4_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow3() throws InterruptedException {
//        Thread.sleep(10_000); // test nya akan gagal karena lebih dari 5 detik
        Thread.sleep(4_000);
    }
}

/*
 NOTE :
* Gunaka annotation @TimeOut untuk memastikan unit test berjalan tidak lebih dari waktu yang telah ditentukan
 */