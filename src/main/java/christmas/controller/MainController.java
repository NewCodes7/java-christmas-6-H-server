package christmas.controller;

import christmas.model.VisitDate;
import christmas.view.InputView;

public class MainController {
    public void excute() {
        setVisitDate();
    }

    private static void setVisitDate() {
        VisitDate visitDate = new VisitDate(InputView.readDate());
    }
}
