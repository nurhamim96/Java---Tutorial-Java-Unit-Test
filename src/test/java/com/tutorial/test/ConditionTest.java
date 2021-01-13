package com.tutorial.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    @EnabledOnOs(OS.LINUX)
   public void testRunOnlyOnLinux() {
        System.out.println("Test dijalankan menggunakan OS : " + System.getProperty("os.name") + ", Versi : " + System.getProperty("os.version"));
   }

    @Test
    @DisabledOnOs(OS.LINUX)
    public void testDisabledOnLinux() {
        System.out.println("Test dijalankan menggunakan OS : " + System.getProperty("os.name") + ", Versi : " + System.getProperty("os.version"));
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testEnabledOnJRE8() {
        System.out.println("Test dijalankan menggunakan JRE : " + System.getProperty("java.version"));
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    public void testDisabledOnJRE8() {
        System.out.println("Test dijalankan menggunakan JRE : " + System.getProperty("java.version"));
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnabledOnJava11To15() {
        System.out.println("Test dijalankan menggunakan JRE VERSI : " + System.getProperty("java.version"));
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisabledOnJava11To15() {
        System.out.println("Test dijalankan menggunakan JRE VERSI : " + System.getProperty("java.version"));
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    })
    public void testEnableOnJavaVendorAmazonCorretto() {
        System.out.println("Anda menggunakan Java dari : " + System.getProperty("java.vendor"));
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Amazon.com Inc.")
    })
    public void testDisabledOnJavaVendorAmazonCorretto() {
        System.out.println("Anda menggunakan Java dari : " + System.getProperty("java.vendor"));
    }

    // Jangan lupa tambahin di Environment Variable nya Key : PROFILE, value : DEV
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {
        System.out.println("Anda sekarang sedang menggunakan profile : " + System.getenv("PROFILE"));
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev() {
        System.out.println("Anda sekarang sedang menggunakan profile : " + System.getenv("PROFILE"));
    }
}

/*
  NOTE:
*  Gunakan anotation @EnabledOnOs() jika ingin menjalankan test di OS tertentu
*  Gunakan anotation @DisabledOnOs() jika ingin menonaktifkan test pada OS tertentu
*  Gunakan anotation @EnabledOnJre() jika ingin menjalankan test pada JRE tertentu
*  Gunakan anotation @DisabledOnJre() jika ingin menonaktifkan test pada JRE tertentu
*  Gunakan anotation @EnabledForJreRange() jika ingin menjalankan test pada JRE Range tertentu
*  Gunakan anotation @DisabledForJreRange() jika ingin menonaktifkan test pada JRE Range tertentu
*  Gunakan anotation @EnabledIfSystemProperty() jika ingin menjalankan test berdasarkan property tertentu
*  Gunakan anotation @EnabledIfSystemProperties() jika lebih dari 1 property
*  Gunakan anotation @DisabledIfSystemProperty() jika ingin menonaktifkan test berdasarkan property tertentu
*  Gunakan anotation @DisabledIfSystemProperties() jika lebih dari 1 property
*  Gunakan anotation @EnabledIfEnvironmentVariable() jika ingin menjalankan test berdasarkan ENV tertentu
*  Gunakan anotation @EnabledIfEnvironmentVariables() jika lebih dari 1 ENV
*  Gunakan anotation @DisabledIfEnvironmentVariable() jika ingin menonaktifkan test berdasarkan ENV tertentu
*  Gunakan anotation @DisabledIfEnvironmentVariables jika lebih dari 1 ENV
*/