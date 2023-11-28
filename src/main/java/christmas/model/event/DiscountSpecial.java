package christmas.model.event;

import christmas.constant.event.EventNumbers;
import christmas.constant.Numbers;

public class DiscountSpecial {
    public int setDiscount(int date) {
        int discount = Numbers.INITIALIZE_ZERO.getValue();
        if (isSpecialDay(date)) {
            discount = EventNumbers.SPECIAL_DISCOUNT.getValue();
        }
        return discount;
    }
    private boolean isSpecialDay(int date) {
        return (date % Numbers.WEEK_LENGTH.getValue() == EventNumbers.SPECIAL_REFERENCE_DAY.getValue())
                || (date == Numbers.CHRISTMAS_DAY.getValue());
    }
}
