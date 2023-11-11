package christmas.model.customer;

import christmas.constant.MenuInfo;
import christmas.constant.Numbers;
import java.awt.Menu;
import java.util.Map;

public class TotalOrderCalculator {
    public int calculateTotalOrder(Map<String, Integer> orderedMenu) {
        int totalOrder = Numbers.INITIALIZE_ZERO.getValue();
        for (String menu : orderedMenu.keySet()) {
            int price = MenuInfo.getMenuBoard().get(menu);
            int amounts = orderedMenu.get(menu);
            totalOrder += price * amounts;
        }
        return totalOrder;
    }
}
