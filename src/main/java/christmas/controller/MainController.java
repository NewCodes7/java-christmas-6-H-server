package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;

public class MainController {
    public void excute() {
        VisitDate visitDate = visitDateController();
        orderMenuController();
        int dDayDiscount = discountChristmasDDayConroller(visitDate);
    }

    private static VisitDate visitDateController() {
        VisitDate visitDate = null;
        boolean isValid = false;
        while (!isValid) {
            try {
                visitDate = new VisitDate(InputView.readDate());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return visitDate;
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

    private static int discountChristmasDDayConroller(VisitDate visitDate) {
        int discount = 0;
        if(visitDate.isChristmasDDayDiscountActive()) {
            discount = visitDate.createDiscountChristmasDDay().calculate();
        }
        return discount;
    }
}
