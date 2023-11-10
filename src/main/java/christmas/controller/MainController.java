package christmas.controller;

import christmas.model.DiscountChristmasDDay;
import christmas.model.DiscountWeek;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Order;

public class MainController {
    public void excute() {
        int date = visitDateController();
        Map<String, Integer>  orderedMenu = orderMenuController();
        int discountDDay = discountChristmasDDayConroller(date);
        int discountWeek = discountWeekConroller(date);
    }

    private static int visitDateController() {
        VisitDate visitDate = new VisitDate();
        int date = 0;
        while (date == 0) {
            try {
                date = visitDate.setVisitDate(InputView.readDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return date;
    }

    private static Map<String, Integer> orderMenuController() {
        OrderMenu orderMenu = new OrderMenu();
        Map<String, Integer> orderedMenu = null;
        while (orderedMenu == null) {
            try {
                orderedMenu = orderMenu.setOrderMenu(InputView.readMenu());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderedMenu;
    }

    private static int discountChristmasDDayConroller(int date) {
        DiscountChristmasDDay discountChristmasDDay = new DiscountChristmasDDay(date);
        return discountChristmasDDay.calculate();
    }

    private static int discountWeekConroller(int date) {
        DiscountWeek discountWeek = new DiscountWeek(date);
        return discountWeek.calculate();
    }
}
