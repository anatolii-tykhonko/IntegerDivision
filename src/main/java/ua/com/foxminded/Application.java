package ua.com.foxminded;

public class Application {
    public static void main(String[] args) {
        Division test1 = new Division();
        System.out.print(test1.divineTwoPositiveIntegers(12345, 13));
        System.out.println(test1.divineTwoPositiveIntegers(900, 3));
        System.out.println(test1.divineTwoPositiveIntegers(1470110, 14));
    }
}
