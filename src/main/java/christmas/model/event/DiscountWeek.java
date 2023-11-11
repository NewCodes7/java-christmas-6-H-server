package christmas.model.event;

import christmas.constant.MenuInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountWeek {
    public int setDiscount(int quantity) {
        return quantity * 2023;
    }

    public static int calculateDiscountedOrderQuantity(Map<String, Integer> orderedMenu, int date) {
        List<String> category = setDiscountCategory(date);
        int quantity = 0;
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
        Integer[] weekend = {1, 2};
        return Arrays.asList(weekend).contains(date % 7);
    }
}
