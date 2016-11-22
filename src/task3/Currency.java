package task3;

public enum Currency {
    EUR("EUR"),
    USD("USD");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
