package com.tutorial.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test untuk Calculator class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test skenario sukses untuk method add(Integer, Integer)")
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
}

/*
  NOTE:
*  Gunakan @DisplayName jika ingin mengganti nama test/ menambahkan deskripsi pada test.
*  GUNAKAN assertThrows() JIKA KITA MENGINGINKAN THROW ERROR PADA TEST NYA.
*
*
*/