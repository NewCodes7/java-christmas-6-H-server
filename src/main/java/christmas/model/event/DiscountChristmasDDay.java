package christmas.model.event;

import christmas.constant.event.EventNumbers;
import christmas.constant.Numbers;

public class DiscountChristmasDDay {
    public static final int FIRST_DAY = 1;

    public int calculate(int date) {
        int discount = Numbers.INITIALIZE_ZERO.getValue();
        if(isChristmasDDayDiscountActive(date)){
            discount = EventNumbers.D_DAY_MIN_DISCOUNT.getValue()
                    + EventNumbers.D_DAY_INCREMENT_AMOUNT.getValue() * (date - FIRST_DAY);
        }
        return discount;
    }

    private boolean isChristmasDDayDiscountActive(int date) {
        return date >= FIRST_DAY && date <= Numbers.CHRISTMAS_DAY.getValue();
    }
}
