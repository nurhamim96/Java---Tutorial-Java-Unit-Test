package com.tutorial.test;

import static org.junit.jupiter.api.Assertions.*;

import com.tutorial.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        var result = calculator.add(10, 10);

        assertEquals(20, result);

        // INI KALO MANUAL TIDAK MENGGUNAKAN ASSERTIONS
//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }
    }

    @Test
    public void testDevideSuccess() {
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    // NOTE : GUNAKAN assertThrows() JIKA KITA MENGINGINKAN THROW ERROR PADA TEST NYA
    @Test
    public void testDevideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.devide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon() {

    }
}

/*
  NOTE:
*  Gunakan @DisplayNameGeneration() untuk menggunakan display name generator lalu masukan kelas generatornya ke dalam parameter seperti berikut @DisplayNameGeneration(SimpleDisplayNameGenerator.class).
*  Gunakan anotation @Disabled jika ingin menonaktifkan test
*/