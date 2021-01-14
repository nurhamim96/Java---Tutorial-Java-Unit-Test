package com.tutorial.test;

import com.tutorial.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbstractCalculatorTest {


    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions() );
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test calculator")
    @ValueSource(ints = {1, 2, 3, 4, 43, 23, 24, 53})
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 3, 4, 6, 23, 24, 43);
    }

    @DisplayName("Test calculator")
    @MethodSource({"parameterSource"})
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    void testWithMethodSource(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}

/*
 NOTE :
* Gunakan annotation @RepeatedTest() jika ingin melakukan perulangan unit test pada method unit test yang sama.
* Gunakan annotation @ValueSource(), untuk sumber Number, Char, Boolean dan String.
* Gunakan annotation @EnumSource(), untuk sumber berupa enum.
* Gunakan annotation @MethodSource(), untuk sumber dari static method.
* Gunakan annotation @CsvSource(), untuk sumber berupa data CSV.
* Gunakan annotation @CsvFileSource(), untuk sumber berupa file CSV.
* Gunakan annotation @ArgumentSource(), untuk data dari class ArgumentProvider.
 */