package christmas.model.customer;

import static christmas.constant.event.EventNumbers.MIN_PRICE_FOR_DISCOUNT;

import christmas.constant.MenuInfo;
import christmas.constant.Numbers;
import java.util.Map;

public class TotalOrderCalculator {
    private static int totalOrder = Numbers.INITIALIZE_ZERO.getValue();

    public int calculateTotalOrder(Map<String, Integer> orderedMenu) {
        for (String menu : orderedMenu.keySet()) {
            int price = MenuInfo.getMenuBoard().get(menu);
            int amounts = orderedMenu.get(menu);
            totalOrder += price * amounts;
        }
        return totalOrder;
    }

    public static boolean checkEventApplied() {
        return totalOrder >= MIN_PRICE_FOR_DISCOUNT.getValue();
    }
}
