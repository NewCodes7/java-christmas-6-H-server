package christmas.model.event;

import christmas.constant.MenuInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountWeek {
    public int setDiscount(Map<String, Integer> orderedMenu, int date) {
        List<String> discountCategoty = MenuInfo.getDessertNames();
        if(isWeekend(date)){
            discountCategoty = MenuInfo.getMainNames();
        }
        return calculate(orderedMenu, discountCategoty, 2023);
    }

    public boolean isWeekend(int date) {
        Integer[] weekend = {1, 2};
        return Arrays.asList(weekend).contains(date % 7);
    }

    private int calculate(Map<String, Integer> orderedMenu, List<String> category, int amount) {
        int discount = 0;
        for(String menu : orderedMenu.keySet()) {
            if (category.contains(menu)) {
                discount += amount * orderedMenu.get(menu);
            }
        }
        return discount;
    }
}
