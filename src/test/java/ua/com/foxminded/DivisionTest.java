package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    Division test = new Division();


    @Test
    void throwIllegalArgumentExceptionWhenDivisorZero() {
        int inputDividend = 12345;
        int inputDivisor = 0;

        assertThrows(IllegalArgumentException.class,
                () -> test.divineTwoPositiveIntegers(inputDividend, inputDivisor));
    }

    @Test
    void throwIllegalArgumentExceptionWhenDividendNegativeDivisorPositive(){
        int inputDividend = -123;
        int inputDivisor = 12;

        assertThrows(IllegalArgumentException.class,
                () -> test.divineTwoPositiveIntegers(inputDividend, inputDivisor));
    }

    @Test
    void throwIllegalArgumentExceptionWhenDividendPositiveDivisorNegative(){
        int inputDividend = 25;
        int inputDivisor = -2;

        assertThrows(IllegalArgumentException.class,
                () -> test.divineTwoPositiveIntegers(inputDividend, inputDivisor));
    }

    @Test
    void throwIllegalArgumentExceptionWhenDividendNegativeDivisorNegative(){
        int inputDividend = -9;
        int inputDivisor = -3;

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
        String expected =   "_9|9\n" +
                            " 9|-\n" +
                            " -|1\n" +
                            " 0\n";

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }
    @Test
    void returnResultWhenDivisorBiggerThatFirstDigitOfDividend() {
        int inputDividend = 12345;
        int inputDivisor = 13;
        String expected =   "_12345|13\n" +
                            " 117  |---\n" +
                            " ---  |949\n" +
                            "  _64\n" +
                            "   52\n" +
                            "   --\n" +
                            "  _125\n" +
                            "   117\n" +
                            "   ---\n" +
                            "     8\n";

        String result = test.divineTwoPositiveIntegers(inputDividend, inputDivisor);

        assertEquals(expected, result);
    }

}