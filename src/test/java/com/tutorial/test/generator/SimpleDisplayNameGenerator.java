package com.tutorial.test.generator;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class SimpleDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(Class<?> aClass) {
        return "Test " + aClass.getSimpleName();
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> aClass, Method method) {
        return "Test " + aClass.getSimpleName() + "." + method.getName();
    }

    // Kita akan pake method dua diatas, jadi yg ini abaikan dulu
    @Override
    public String generateDisplayNameForNestedClass(Class<?> aClass) {
        return null;
    }
}
