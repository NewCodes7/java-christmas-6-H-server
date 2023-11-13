package christmas.controller;

import christmas.view.OutputView;

public class MainController {
    private final CustomerController customerController;
    private final EventController eventController;

    public MainController() {
        customerController = new CustomerController();
        eventController = new EventController();
    }

    public void excute() {
        Integer[] data = customerController.excute();
        eventController.excute(data);
        OutputView.printTipMinDiscountApplied(data[1]);
    }
}