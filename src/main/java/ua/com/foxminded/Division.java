package ua.com.foxminded;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String dividend;
    private String[] digitsDividend;
    private int divisor;
    private StringBuilder buildQuotient;
    private List<String> viewResult;
    private StringBuilder buildViewResult;

    public void makeDivision(int dividend, int divisor){
        this.divisor = divisor;
        this.dividend = String.valueOf(dividend);
        digitsDividend = this.dividend.split("");
        buildQuotient = new StringBuilder();
        viewResult = new ArrayList<>();
        buildViewResult = new StringBuilder("_" + dividend + "|" + divisor);
        viewResult.add(buildViewResult.toString());
        divine();
        int quotient = Integer.parseInt(buildQuotient.toString());
        //create second line the result
        viewResult.remove(viewResult.get(1));
        String secondLineViewResult = viewResult.get(1);
        buildViewResult = new StringBuilder(secondLineViewResult);
        buildViewResult.append(stringWithSomeRepeatSymbol(" ", this.dividend.length() - secondLineViewResult.length() + 1)).
                append("|").
                append(stringWithSomeRepeatSymbol("-", String.valueOf(quotient).length()));
        viewResult.add(1, buildViewResult.toString());
        viewResult.remove(viewResult.get(2));
        //create third line the result
        String thirdLineViewResult = viewResult.get(2);
        buildViewResult = new StringBuilder(thirdLineViewResult);
        buildViewResult.append(stringWithSomeRepeatSymbol(" ", this.dividend.length() - thirdLineViewResult.length() + 1)).
                append("|").
                append(quotient);
        viewResult.add(2, buildViewResult.toString());
        viewResult.remove(viewResult.get(3));
        viewResult.forEach(System.out::println);
        System.out.println(Integer.parseInt(buildQuotient.toString()));
        
    }

    private void divine() {
        StringBuilder subDividendToString = new StringBuilder();
        int subDividend;
        for (int i = 0; i < digitsDividend.length; i++) {
            subDividendToString.append(digitsDividend[i]);
            subDividend = Integer.parseInt(subDividendToString.toString());
            if(subDividend >= divisor){
                int subResult = subDividend / divisor;
                int multiply = subResult * divisor;
                buildQuotient.append(subResult);
                viewResult.add(String.format("%" + (i +2) + "s", "_" + subDividend));
                viewResult.add(String.format("%" + (i + 2) + "s", multiply));
                viewResult.add(String.format("%" + (i + 2) + "s", stringWithSomeRepeatSymbol("-", String.valueOf(multiply).length())));
                subDividendToString = new StringBuilder(String.valueOf(subDividend % divisor));

            } else{
                buildQuotient.append(0);
            }
        }
        viewResult.add(String.format("%" + (digitsDividend.length + 1) + "s",subDividendToString.toString()));
    }
    private String stringWithSomeRepeatSymbol(String symbol, int count){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < count; i++) {
            string.append(symbol);
        }
        return string.toString();
    }



}
