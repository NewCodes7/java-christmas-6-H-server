package christmas.controller;

import christmas.model.VisitDate;
import christmas.view.InputView;

public class MainController {
    public void excute() {
        visitDateController();
    }

    private static void visitDateController() {
        boolean isValid = false;
        while(!isValid) {
            try {
                VisitDate visitDate = new VisitDate(InputView.readDate());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
