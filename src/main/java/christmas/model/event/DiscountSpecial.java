package christmas.model.event;

import christmas.constant.Numbers;

public class DiscountSpecial {

    public static final int SPECIAL_DISCOUNT = 1000;
    public static final int SPECIAL_DAY = 3;

    public int setDiscount(int date) {
        int discount = Numbers.INITIALIZE_ZERO.getValue();
        if (isSpecialDay(date)) {
            discount = SPECIAL_DISCOUNT;
        }
        return discount;
    }
    private boolean isSpecialDay(int date) {
        return (date % Numbers.WEEK_LENGTH.getValue() == SPECIAL_DAY) || (date == Numbers.CHRISTMAS_DAY.getValue());
    }
}
