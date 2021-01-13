package com.tutorial.test;

import static org.junit.jupiter.api.Assertions.*;

import com.tutorial.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Each");
    }

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

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");

        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // dan silahkan tambahkan unit test jika dia DEV dibawah ini
    }
}

/*
  NOTE:
*  Gunakan @DisplayNameGeneration() untuk menggunakan display name generator lalu masukan kelas generatornya ke dalam parameter seperti berikut @DisplayNameGeneration(SimpleDisplayNameGenerator.class).
*  Gunakan anotation @Disabled jika ingin menonaktifkan test
*  Gunakan @BeforeEach jika ingin menjalankan perintah sebelum test disetiap method test
*  Gunakan @AfterEach jika ingin menjalankan perintah setelah test disetiap method test
*  @BeforeEach dan @AfterEach akan dijalankan di setiap method test
*  Gunakan @BeforeAll jika ingin menjalankan perintah sekali sebelum test
*  Gunakan @AfterAll jika ingin menjalankan perintah sekali sebelum test
*  @BeforeAll dan @AfterAll hanya bisa dijalankan pada method static
*  Gunakan exception TestAbortedException() untuk membatalkan test secara manual.
*/