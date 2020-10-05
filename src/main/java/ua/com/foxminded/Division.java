package ua.com.foxminded;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String dividend;
    private String[] digitsDividend;
    private int divisor;
    private StringBuilder buildQuotient;
    private int quotient;
    private List<String> linesViewResult;

    public String makeDivision(int dividend, int divisor) {

        if(divisor == 0){
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        if(dividend < divisor){
            return dividend + " / " + divisor + " = 0";
        }
        initializeInstanceVariable(dividend, divisor);
        divine();
        return modifyResultToString();
    }

    private String modifyResultToString() {
        String firstLineResult = "_" + dividend + "|" + divisor;
        linesViewResult.add(0, firstLineResult);
        linesViewResult.remove(linesViewResult.get(1));

        String secondLineViewResult = linesViewResult.get(1);
        StringBuilder buildViewResult = new StringBuilder(secondLineViewResult);
        buildViewResult.append(stringWithSomeRepeatSymbol(" ", this.dividend.length() - secondLineViewResult.length() + 1)).
                append("|").
                append(stringWithSomeRepeatSymbol("-", String.valueOf(quotient).length()));
        linesViewResult.add(1, buildViewResult.toString());
        linesViewResult.remove(linesViewResult.get(2));

        String thirdLineViewResult = linesViewResult.get(2);
        buildViewResult = new StringBuilder(thirdLineViewResult);
        buildViewResult.append(stringWithSomeRepeatSymbol(" ", this.dividend.length() - thirdLineViewResult.length() + 1)).
                append("|").
                append(quotient);
        linesViewResult.add(2, buildViewResult.toString());
        linesViewResult.remove(linesViewResult.get(3));
        buildViewResult = new StringBuilder();

        for(String result : linesViewResult){
            buildViewResult.append(result).append("\n");
        }
        return buildViewResult.toString();
    }

    private void initializeInstanceVariable(int dividend, int divisor) {
        this.divisor = divisor;
        this.dividend = String.valueOf(dividend);
        digitsDividend = this.dividend.split("");
        buildQuotient = new StringBuilder();
        quotient = 0;
        linesViewResult = new ArrayList<>();


    }

    private void divine() {
        StringBuilder subDividendToString = new StringBuilder();
        int subDividend;
        for (int i = 0; i < digitsDividend.length; i++) {
            subDividendToString.append(digitsDividend[i]);
            subDividend = Integer.parseInt(subDividendToString.toString());
            if (subDividend >= divisor) {
                int subResult = subDividend / divisor;
                int multiply = subResult * divisor;
                buildQuotient.append(subResult);
                linesViewResult.add(String.format("%" + (i + 2) + "s", "_" + subDividend));
                linesViewResult.add(String.format("%" + (i + 2) + "s", multiply));
                linesViewResult.add(String.format("%" + (i + 2) + "s", stringWithSomeRepeatSymbol("-", String.valueOf(multiply).length())));
                subDividendToString = new StringBuilder(String.valueOf(subDividend % divisor));
            } else {
                buildQuotient.append(0);
            }
        }
        linesViewResult.add(String.format("%" + (digitsDividend.length + 1) + "s", subDividendToString.toString()));
        quotient = Integer.parseInt(buildQuotient.toString());
    }

    private String stringWithSomeRepeatSymbol(String symbol, int count) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < count; i++) {
            string.append(symbol);
        }
        return string.toString();
    }


}
