package christmas.model.event;

import christmas.constant.MenuInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountSpecial {

    public int setDiscount(int date) {
        int discount = 0;
        if (isSpecialDay(date)) {
            discount = 1000;
        }
        return discount;
    }
    private boolean isSpecialDay(int date) {
        return (date%7 == 3) || (date == 25);
    }
}
