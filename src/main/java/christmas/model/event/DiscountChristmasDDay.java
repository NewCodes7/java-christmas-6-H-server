package christmas.model.event;

public class DiscountChristmasDDay {
    public int calculate(int date) {
        int discount = 0;
        if(isChristmasDDayDiscountActive(date)){
            discount = 1000 + 100*(date-1);
        }
        return discount;
    }

    private boolean isChristmasDDayDiscountActive(int date) {
        return date >= 1 && date <= 25;
    }
}
