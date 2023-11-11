package christmas.controller;

import christmas.constant.Message;
import christmas.constant.Numbers;
import christmas.model.customer.OrderMenu;
import christmas.model.customer.TotalOrderCalculator;
import christmas.model.customer.VisitDate;
import christmas.model.event.DiscountWeek;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class CustomerController {
    private static final int INITIALIZE_ZERO = 0;
    public Integer[] excute() {
        // customer - 날짜 및 메뉴 입력받기, 주문한 메뉴 출력, 할인 전 총주문 금액 출력
        int date = visitDateController();
        Map<String, Integer> orderedMenu = orderMenuController();
        int totalOrderAmount = totalOrderCalculator(orderedMenu);
        int discountWeekQuantity = DiscountWeek.calculateDiscountedOrderQuantity(orderedMenu, date);
        Integer[] data = {date, totalOrderAmount, discountWeekQuantity};
        return data;
    }

    private static int visitDateController() {
        VisitDate visitDate = new VisitDate();
        int date = INITIALIZE_ZERO;
        while (date == INITIALIZE_ZERO) {
            try {
                date = visitDate.setVisitDate(InputView.readDate());
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
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
                OutputView.print(e.getMessage());
            }
        }
        OutputView.print(Message.EXPECTED_EVENT.getMessage());
        OutputView.printOrderedMenu(orderedMenu);
        return orderedMenu;
    }

    private static int totalOrderCalculator(Map<String, Integer> orderedMenu) {
        TotalOrderCalculator totalOrderCalculator = new TotalOrderCalculator();
        int totalOrderAmount = totalOrderCalculator.calculateTotalOrder(orderedMenu);
        OutputView.printTotalOrderAmount(totalOrderAmount);
        return totalOrderAmount;
    }
}
