package christmas.controller;

import christmas.view.OutputView;

public class MainController {
    public static final int INDEX_TOTAL_ORDER_AMOUNT = 1;
    public static final int INDEX_DATE = 0;
    public static final int INDEX_WEEK_DISCOUNT_AMOUNT = 2;
    private final CustomerController customerController;
    private final EventController eventController;

    public MainController() {
        customerController = new CustomerController();
        eventController = new EventController();
    }

    public void excute() {
        Integer[] data = customerController.excute();
        eventController.excute(data);
        OutputView.printTipMinDiscountApplied(data[INDEX_TOTAL_ORDER_AMOUNT]);
        OutputView.printTipWeekDiscount(data[INDEX_DATE], data[INDEX_WEEK_DISCOUNT_AMOUNT]);
    }
}