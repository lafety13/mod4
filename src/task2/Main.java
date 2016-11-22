package task2;

public class Main {
    public static void main(String[] args) {
        int lengthOfEnum = Currency.values().length;

        for (int i = 0; i < lengthOfEnum; ++i) {
            System.out.println(Currency.values()[i]);
        }


    }
}
