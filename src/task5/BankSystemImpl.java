package task5;

import task4.User;
import task4.*;

public class BankSystemImpl implements BankSystem {

    @Override
    public void withdrawOfUser(User user, int amount) {
        int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
        int commission = user.getBank().getCommission(amount);

        if (amount > limitOfWithdrawal) {
            System.out.println("Your limit of withdrawal is " + limitOfWithdrawal);
        } else if ((user.getBalance() - (amount + commission) < 0)) {
            System.out.println("Not enough money on account. Your balance is " + user.getBalance());
        } else {
            user.setBalance(user.getBalance() - (amount + commission));
            System.out.println("Operation is successfully finished. Commission is " +
                    commission + ". " + amount + " was withdrawn. Balance is " + user.getBalance()
            );
        }

    }

    @Override
    public void fundUser(User user, int amount) {
        int limitOfFounding = user.getBank().getLimitOfFunding();

        if (amount > limitOfFounding) {
            System.out.println("Amount exceeds the limit. Your limit of founding is " + limitOfFounding);
        } else {
            user.setBalance(user.getBalance() + amount);
            System.out.println("funding " + amount + " balance " + user.getBalance());
        }

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        int commissionFromUser = fromUser.getBank().getCommission(amount);

        if ((commissionFromUser < 0) ||
                (fromUser.getBalance() - (amount + commissionFromUser) < 0)) {
            System.out.println("Not enough money on account.");
        } else {
            fromUser.setBalance(fromUser.getBalance() - (amount + commissionFromUser));
            toUser.setBalance(toUser.getBalance() + amount);
            System.out.println("Transfer (From " + fromUser.getName() + " to " + toUser.getName() +
                    ")\n\tAmount = " + amount + " Commission " + commissionFromUser +
                    " \n\tYour balance is " + fromUser.getBalance()
            );
        }
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary());
        System.out.println("Your salary is " + user.getSalary() + "balance" + user.getBalance());

    }
}
