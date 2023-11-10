package christmas.controller;

import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;
import org.junit.jupiter.api.Order;

public class MainController {
    public void excute() {
        visitDateController();
        orderMenuController();
    }

    private static void visitDateController() {
        boolean isValid = false;
        while (!isValid) {
            try {
                VisitDate visitDate = new VisitDate(InputView.readDate());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
}
