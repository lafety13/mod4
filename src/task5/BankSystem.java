package task5;

import task4.User;

public interface BankSystem {
    void withdrawOfUser(User user, int amount);
    void fundUser(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}
