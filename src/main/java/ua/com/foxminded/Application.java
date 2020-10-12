package ua.com.foxminded;

public class Application {
    public static void main(String[] args) {
        IntegerDivision test1 = new IntegerDivision();
        System.out.println(test1.divideTwoPositiveIntegers(1430, 130));
        System.out.println(test1.divideTwoPositiveIntegers(900, 3));
        System.out.println(test1.divideTwoPositiveIntegers(1470110, 14));
        System.out.println(test1.divideTwoPositiveIntegers(0, 99));
        System.out.println(test1.divideTwoPositiveIntegers(40, 99));
    }
}
