package ua.com.foxminded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    Division test = new Division();

    @Test
    void printResultWhenDivisorContentTwoDigit(){
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
        String result = test.makeDivision(inputDividend, inputDivisor);
        assertEquals(expected, result);
    }

}