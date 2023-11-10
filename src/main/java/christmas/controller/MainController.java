package christmas.controller;

import christmas.model.DiscountChristmasDDay;
import christmas.model.DiscountSpecial;
import christmas.model.DiscountWeek;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    public void excute() {
        int date = visitDateController();
        Map<String, Integer> orderedMenu = orderMenuController();
        int discountDDay = discountChristmasDDayConroller(date);
        int discountWeek = discountWeekConroller(orderedMenu, date);
        int discountSpecial = discountSpecialController(date);
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
        Map<String, Integer> orderedMenu = new HashMap<>();
        while (orderedMenu.isEmpty()) {
            try {
                orderedMenu = orderMenu.setOrderMenu(InputView.readMenu());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return orderedMenu;
    }

    private static int discountChristmasDDayConroller(int date) {
        DiscountChristmasDDay discountChristmasDDay = new DiscountChristmasDDay();
        return discountChristmasDDay.calculate(date);
    }

    private static int discountWeekConroller(Map<String, Integer> orderedMenu, int date) {
        DiscountWeek discountWeek = new DiscountWeek();
        return discountWeek.setDiscount(orderedMenu, date);
    }

    private static int discountSpecialController(int date) {
        DiscountSpecial discountSpecial = new DiscountSpecial();
        return discountSpecial.setDiscount(date);
    }
}
