package christmas.model;

public class DiscountChristmasDDay {
    private static int date;

    public DiscountChristmasDDay(int date) {
        DiscountChristmasDDay.date = date;
    }

    public int calculate() {
        return 1000 + 100*(date-1);
    }
}
