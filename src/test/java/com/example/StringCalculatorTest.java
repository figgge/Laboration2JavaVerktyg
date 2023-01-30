package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void emptyStringShouldReturnZero(){
        var result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void oneAndOneShouldReturnTwo() {
        var result = stringCalculator.add("1,1");

        assertThat(result).isEqualTo(2);
    }

    @Test
    void oneAndTwoShouldReturnThree() {
        var result = stringCalculator.add("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void addFourNumbersShouldReturnCorrectSum() {
        var result = stringCalculator.add("1,2,3,10");

        assertThat(result).isEqualTo(16);
    }

    @Test
    void addThreeNumbersSeparatedByNewLineShouldReturnSum(){
        var result = stringCalculator.add("""
                1,2
                3
                """);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void colonShouldSplitNumbersAndReturnSum() {
        var result = stringCalculator.add("//:\n10:2:3");

        assertThat(result).isEqualTo(15);
    }

    @Test
    void negativeNumbersShouldThrowException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("-1,-2");
        });

        String expected = "negatives not allowed\n-1\n-2";
        String result = exception.getMessage();

        assertThat(result).isEqualTo(expected);
    }

}
