package christmas.model.event;

import christmas.constant.Numbers;

public class DiscountChristmasDDay {
    public static final int MIN_DISCOUNT = 1000;
    public static final int INCREMENT_AMOUNT = 100;
    public static final int FIRST_DAY = 1;

    public int calculate(int date) {
        int discount = Numbers.INITIALIZE_ZERO.getValue();
        if(isChristmasDDayDiscountActive(date)){
            discount = MIN_DISCOUNT + INCREMENT_AMOUNT * (date - FIRST_DAY);
        }
        return discount;
    }

    private boolean isChristmasDDayDiscountActive(int date) {
        return date >= FIRST_DAY && date <= Numbers.CHRISTMAS_DAY.getValue();
    }
}
