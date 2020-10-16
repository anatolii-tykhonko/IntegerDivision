package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionTest {
    IntegerDivision test = new IntegerDivision();

    @Test
    void divideTwoPosIntegersThrowIllegalArgumentExceptionWhenDivisorZero() {
        int inputDividend = 12345;
        int inputDivisor = 0;

        assertThrows(IllegalArgumentException.class,
                () -> test.longDivideTwoPositiveInteger(inputDividend, inputDivisor));
    }

    @Test
    void divideTwoPosIntegersShouldFormatWhenDividendIsZero() {
        int inputDividend = 0;
        int inputDivisor = 99;
        String expected = String
                .format("_0|99%n" +
                        " 0|--%n" +
                        " -|0%n" +
                        " 0%n");

        String result = test.longDivideTwoPositiveInteger(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void divideTwoPosIntegersReturnOnlyFourLinesWhenDividendEqualsDivisor(){
        int inputDividend = 9;
        int inputDivisor = 9;
        String expected = String
                .format("_9|9%n" +
                        " 9|-%n" +
                        " -|1%n" +
                        " 0%n");

        String result = test.longDivideTwoPositiveInteger(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void divideTwoPosIntegersShouldFormatWhenDivisorBiggerThatFirstDigitOfDividend() {
        int inputDividend = 12345;
        int inputDivisor = 13;
        String expected = String
                .format("_12345|13%n" +
                        " 117  |---%n" +
                        " ---  |949%n" +
                        "  _64%n" +
                        "   52%n" +
                        "   --%n" +
                        "  _125%n" +
                        "   117%n" +
                        "   ---%n" +
                        "     8%n");

        String result = test.longDivideTwoPositiveInteger(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void divideTwoPosIntegersShouldFormatWhenDividendContainsThreeZero(){
        int inputDividend = 10002;
        int inputDivisor = 3;
        String expected =String
                .format("_10002|3%n" +
                        "  9   |----%n" +
                        "  -   |3334%n" +
                        " _10%n" +
                        "   9%n" +
                        "   -%n" +
                        "  _10%n" +
                        "    9%n" +
                        "    -%n" +
                        "   _12%n" +
                        "    12%n" +
                        "    --%n" +
                        "     0%n");

        String result = test.longDivideTwoPositiveInteger(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void divideTwoPosIntegersShouldFormatWhenQuotientContainsTwoZero(){
        int inputDividend = 6030;
        int inputDivisor = 6;
        String expected = String
                .format("_6030|6%n" +
                        " 6   |----%n" +
                        " -   |1005%n" +
                        "  _30%n" +
                        "   30%n" +
                        "   --%n" +
                        "    0%n");

        String result = test.longDivideTwoPositiveInteger(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }
}