package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

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

}
