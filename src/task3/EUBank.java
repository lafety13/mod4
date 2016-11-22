package task3;

public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees,
                  double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        int limitOfWithdrawal = 0;

        switch(this.getCurrency()) {
            case EUR:
                limitOfWithdrawal = 2200;
                break;
            case USD:
                limitOfWithdrawal = 2000;
                break;
        }
        return limitOfWithdrawal;
    }

    @Override
    public int getLimitOfFunding() {
        int limitOfFunding = 0;

        switch (this.getCurrency()) {
            case EUR:
                limitOfFunding = 20000;
                break;
            case USD:
                limitOfFunding = 10000;
                break;
        }
        return limitOfFunding;
    }

    @Override
    public int getMonthlyRate() {
        int monthlyRate = 0;

        switch(this.getCurrency()) {
            case EUR:
                monthlyRate = 1;
                break;
            case USD:
                monthlyRate = 0;
                break;
        }
        return monthlyRate;
    }

    @Override
    public int getCommission(int summ) {
        int commission = 0;

        switch (this.getCurrency()) {
            case USD:
                commission = summ * ((summ <= 1000) ? 5 : 7) / 100;
                break;
            case EUR:
                commission = summ * ((summ <= 1000) ? 2 : 4) / 100;
                break;
        }
        return commission;
    }

}
