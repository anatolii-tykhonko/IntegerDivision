package ua.com.foxminded;

public class Application {
    public static void main(String[] args) {
        IntegerDivision test1 = new IntegerDivision();
        System.out.println(test1.divineTwoPositiveIntegers(12345, 13));
        System.out.println(test1.divineTwoPositiveIntegers(900, 3));
        System.out.println(test1.divineTwoPositiveIntegers(1470110, 14));
        System.out.println(test1.divineTwoPositiveIntegers(6030, 6));
    }
}
