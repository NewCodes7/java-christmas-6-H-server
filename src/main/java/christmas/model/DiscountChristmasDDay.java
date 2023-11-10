package christmas.model;

public class DiscountChristmasDDay {
    private static int date;

    public DiscountChristmasDDay(int date) {
        DiscountChristmasDDay.date = date;
    }

    private boolean isChristmasDDayDiscountActive() {
        return date >= 1 && date <= 25;
    }

    public int calculate() {
        int discount = 0;
        if(isChristmasDDayDiscountActive()){
            discount = 1000 + 100*(date-1);
        }
        return discount;
    }
}
