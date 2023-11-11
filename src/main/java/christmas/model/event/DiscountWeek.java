package christmas.model.event;

import christmas.constant.MenuInfo;
import christmas.constant.Numbers;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountWeek {
    public static final int DISCOUNT_AMOUNT_WEEK_AND_WEEKEND = 2023;
    public static final int FRIDAY = 1;
    public static final int SATURDAY = 2;

    public int setDiscount(int quantity) {
        return quantity * DISCOUNT_AMOUNT_WEEK_AND_WEEKEND;
    }

    public static int calculateDiscountedOrderQuantity(Map<String, Integer> orderedMenu, int date) {
        List<String> category = setDiscountCategory(date);
        int quantity = Numbers.INITIALIZE_ZERO.getValue();
        for(String menu : orderedMenu.keySet()) {
            if (category.contains(menu)) {
                quantity += orderedMenu.get(menu);
            }
        }
        return quantity;
    }

    public static List<String> setDiscountCategory(int date) {
        List<String> discountCategoty = MenuInfo.getDessertNames();
        if(isWeekend(date)){
            discountCategoty = MenuInfo.getMainNames();
        }
        return discountCategoty;
    }

    private static boolean isWeekend(int date) {
        Integer[] weekend = {FRIDAY, SATURDAY};
        return Arrays.asList(weekend).contains(date % Numbers.WEEK_LENGTH.getValue());
    }
}
