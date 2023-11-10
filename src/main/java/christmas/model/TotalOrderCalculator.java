package christmas.model;

import christmas.constant.MenuInfo;
import java.awt.Menu;
import java.util.Map;

public class TotalOrderCalculator {
    public int calculateTotalOrder(Map<String, Integer> orderedMenu) {
        int totalOrder = 0;
        for (String menu : orderedMenu.keySet()) {
            int price = MenuInfo.getMenuBoard().get(menu);
            int amounts = orderedMenu.get(menu);
            totalOrder += price * amounts;
        }
        return totalOrder;
    }
}
