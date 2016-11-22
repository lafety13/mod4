package task3;

public class USBank extends Bank {

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees,
                  double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        int limitOfWithdrawal = 0;

        switch(this.getCurrency()) {
            case EUR:
                limitOfWithdrawal = 1200;
                break;
            case USD:
                limitOfWithdrawal = 1000;
                break;
        }
        return limitOfWithdrawal;
    }

    @Override
    public int getLimitOfFunding() {
        int limitOfFunding = 0;

        switch (this.getCurrency()) {
            case EUR:
                limitOfFunding = 10000;
                break;
            case USD:
                limitOfFunding = Integer.MAX_VALUE;
                break;
        }
        return limitOfFunding;
    }

    @Override
    public int getMonthlyRate() {
        int monthlyRate = 0;

        switch(this.getCurrency()) {
            case EUR:
                monthlyRate = 2;
                break;
            case USD:
                monthlyRate = 1;
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
                commission = summ * ((summ <= 1000) ? 6 : 8) / 100;
                break;
        }
        return commission;
    }

}
