package task6;

import task3.*;
import task4.User;
import task5.BankSystemImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static long bankId = 0;
    private static long userId = 0;

    public static void main(String[] args) {

        Bank euBank = new EUBank(bankId++, "Ukraine", Currency.EUR,
                getRandomValue(), getRandomValue(), getRandomValue(), getRandomValue());
        Bank usBank = new USBank(bankId++, "Ukraine", Currency.USD,
                getRandomValue(), getRandomValue(), getRandomValue(), getRandomValue());
        Bank chinaBank = new ChinaBank(bankId++, "Ukraine", Currency.EUR,
                getRandomValue(), getRandomValue(), getRandomValue(), getRandomValue());

        BankSystemImpl bankSystem = new BankSystemImpl();

        User user1 = new User(userId++, "Vadim", 5500, 12, "IBM", 12000, euBank);
        User user2 = new User(userId++, "Ivan", 3000, 2, "BBC", 22000, euBank);
        User user3 = new User(userId++, "Inna", 52000, 31, "IBM", 8000, usBank);
        User user4 = new User(userId++, "John", 4500, 8, "BBC", 13000, usBank);
        User user5 = new User(userId++, "Vladislav", 2000, 15, "BBC", 10000, chinaBank);
        User user6 = new User(userId++, "Ira", 2110, 1, "BBC", 9000, chinaBank);

        User user7 = new User(userId++, "Igor", 5000, 6, "BBC", 17100, chinaBank);

        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        users.forEach((user) -> {
            System.out.println("User ID " + user.getId());
            System.out.println("Balance " + user.getBalance());
            bankSystem.withdrawOfUser(user, 100);
            bankSystem.fundUser(user, 20000);
            System.out.println("User Igor. Balance is " + user7.getBalance());
            bankSystem.transferMoney(user, user7, 1000);
            System.out.println("User Igor. Balance is " + user7.getBalance());
            bankSystem.paySalary(user);
            System.out.println();
        });

    }

    private static int getRandomValue() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}