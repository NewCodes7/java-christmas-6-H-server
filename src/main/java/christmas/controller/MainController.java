package christmas.controller;

import christmas.model.DiscountChristmasDDay;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;

public class MainController {
    public void excute() {
        int date = visitDateController();
        orderMenuController();
        int discountDDay = discountChristmasDDayConroller(date);

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

    private static void orderMenuController() {
        boolean isValid = false;
        while (!isValid) {
            try {
                OrderMenu orderMenu = new OrderMenu(InputView.readMenu());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int discountChristmasDDayConroller(int date) {
        DiscountChristmasDDay discountChristmasDDay = new DiscountChristmasDDay(date);
        return discountChristmasDDay.calculate();
    }


}
