package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDivisionTest {
    IntegerDivision test = new IntegerDivision();

    @Test
    void throwIllegalArgumentExceptionWhenDivisorZero() {
        int inputDividend = 12345;
        int inputDivisor = 0;

        assertThrows(IllegalArgumentException.class,
                () -> test.divineTwoPositiveIntegers(inputDividend, inputDivisor));
    }

    @Test
    void returnOneLineStringWhereDividendDivisorEqualsZeroWhenDivisorBiggerDividend() {
        int inputDividend = 0;
        int inputDivisor = 2;
        String expected = "0 / 2 = 0";

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void returnOnlyFourLinesWhenDividendEqualsDivisor(){
        int inputDividend = 9;
        int inputDivisor = 9;
        String expected =   "_9|9" + System.lineSeparator() +
                            " 9|-" + System.lineSeparator() +
                            " -|1" + System.lineSeparator() +
                            " 0" + System.lineSeparator();

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void returnResultWhenDivisorBiggerThatFirstDigitOfDividend() {
        int inputDividend = 12345;
        int inputDivisor = 13;
        String expected =   "_12345|13" + System.lineSeparator() +
                            " 117  |---" + System.lineSeparator() +
                            " ---  |949" + System.lineSeparator() +
                            "  _64" + System.lineSeparator() +
                            "   52" + System.lineSeparator() +
                            "   --" + System.lineSeparator() +
                            "  _125" + System.lineSeparator() +
                            "   117" + System.lineSeparator() +
                            "   ---" + System.lineSeparator() +
                            "     8" + System.lineSeparator();

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void returnResultWhenDividendContainsThreeZero(){
        int inputDividend = 10002;
        int inputDivisor = 3;
        String expected =   "_10002|3" + System.lineSeparator() +
                            "  9   |----" + System.lineSeparator() +
                            "  -   |3334" + System.lineSeparator() +
                            " _10" + System.lineSeparator() +
                            "   9" + System.lineSeparator() +
                            "   -" + System.lineSeparator() +
                            "  _10" + System.lineSeparator() +
                            "    9" + System.lineSeparator() +
                            "    -" + System.lineSeparator() +
                            "   _12" + System.lineSeparator() +
                            "    12" + System.lineSeparator() +
                            "    --" + System.lineSeparator() +
                            "     0" + System.lineSeparator();

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

    @Test
    void returnResultWhenQuotientContainsTwoZero(){
        int inputDividend = 6030;
        int inputDivisor = 6;
        String expected =   "_6030|6" + System.lineSeparator() +
                            " 6   |----" + System.lineSeparator() +
                            " -   |1005" + System.lineSeparator() +
                            "  _30" + System.lineSeparator() +
                            "   30" + System.lineSeparator() +
                            "   --" + System.lineSeparator() +
                            "    0" + System.lineSeparator();

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }
}