package ua.com.foxminded;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

    public String longDivideTwoPositiveInteger(int inputDividend, int inputDivisor) {
        int [] correctDividendAndDivisor = validateInputData(inputDividend, inputDivisor);
        if(correctDividendAndDivisor[0] >= correctDividendAndDivisor[1]){
            return resultToStringDivide(correctDividendAndDivisor[0], correctDividendAndDivisor[1]);
        } else {
            return resultToStringWhenDividendLessThanDivisor(correctDividendAndDivisor[0], correctDividendAndDivisor[1]);
        }
    }

    private int[] validateInputData(int inputDividend, int inputDivisor) {
        if(inputDivisor == 0){
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        int[] positiveDividendAndDivisor = new int[2];
        positiveDividendAndDivisor[0] = Math.abs(inputDividend);
        positiveDividendAndDivisor[1] = Math.abs(inputDivisor);
        return positiveDividendAndDivisor;
    }

    private String resultToStringDivide(int dividend, int divisor) {
        String[] digitsDividend = String.valueOf(dividend).split("");
        StringBuilder subDividendString = new StringBuilder();
        StringBuilder quotientToString = new StringBuilder();
        List<String> linesViewResult = new ArrayList<>();

        int subDividend;
        for (int i = 0; i < digitsDividend.length; i++) {
            if(subDividendString.toString().equals("0")){
                subDividendString = new StringBuilder(digitsDividend[i]);
            }else {
                subDividendString.append(digitsDividend[i]);
            }
            subDividend = Integer.parseInt(subDividendString.toString());
            if (subDividend >= divisor) {
                int subResult = subDividend / divisor;
                int multiply = subResult * divisor;
                quotientToString.append(subResult);
                String formatLine = "%" + (i + 2) + "s";
                linesViewResult.add(String.format(formatLine, "_" + subDividend));
                linesViewResult.add(String.format(formatLine, multiply));
                linesViewResult.add(String.format(formatLine, stringWithSomeRepeatSymbol("-", String.valueOf(multiply).length())));
                subDividendString = new StringBuilder(String.valueOf(subDividend % divisor));
            } else {
                quotientToString.append(0);
            }
        }
        linesViewResult.add(String.format("%" + (digitsDividend.length + 1) + "s", subDividendString.toString()));
        int quotient = Integer.parseInt(quotientToString.toString());
        return modifyResultToString(linesViewResult, dividend, divisor, quotient);
    }

    private String modifyResultToString(List<String> linesViewResult, int dividend, int divisor, int quotient) {
        String firstLineResult = "_" + dividend + "|" + divisor;
        linesViewResult.add(0, firstLineResult);
        linesViewResult.remove(linesViewResult.get(1));

        String secondLineViewResult = linesViewResult.get(1);
        StringBuilder buildViewResult = new StringBuilder(secondLineViewResult);
        buildViewResult.
                append(stringWithSomeRepeatSymbol(" ", String.valueOf(dividend).length() - secondLineViewResult.length() + 1)).
                append("|").
                append(stringWithSomeRepeatSymbol("-", Math.max(String.valueOf(divisor).length(), String.valueOf(quotient).length())));
        linesViewResult.add(1, buildViewResult.toString());
        linesViewResult.remove(linesViewResult.get(2));

        String thirdLineViewResult = linesViewResult.get(2);
        buildViewResult = new StringBuilder(thirdLineViewResult);
        buildViewResult.
                append(stringWithSomeRepeatSymbol(" ", String.valueOf(dividend).length() - thirdLineViewResult.length() + 1)).
                append("|").
                append(quotient);
        linesViewResult.add(2, buildViewResult.toString());
        linesViewResult.remove(linesViewResult.get(3));
        buildViewResult = new StringBuilder();

        for(String result : linesViewResult){
            buildViewResult.append(result).append(System.lineSeparator());
        }
        return buildViewResult.toString();
    }

    private String resultToStringWhenDividendLessThanDivisor(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        String format = "%" + (String.valueOf(dividend).length() + 1) + "s";
        result.append("_" + dividend + "|" + divisor)
                .append(System.lineSeparator());
        result.append(String.format(format, "0"))
                .append("|")
                .append(stringWithSomeRepeatSymbol("-", String.valueOf(divisor).length()))
                .append(System.lineSeparator());
        result.append(String.format(format, "-"))
                .append("|0")
                .append(System.lineSeparator());
        result.append(String.format(format, dividend))
                .append(System.lineSeparator());
        return result.toString();
    }

    private String stringWithSomeRepeatSymbol(String symbol, int count) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < count; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
