package christmas.controller;

import static christmas.constant.Message.EXPECTED_EVENT;
import static christmas.constant.Numbers.INITIALIZE_ZERO;

import christmas.constant.MenuInfo;
import christmas.model.customer.OrderMenu;
import christmas.model.customer.TotalOrderCalculator;
import christmas.model.customer.VisitDate;
import christmas.model.event.DiscountWeek;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class CustomerController {
    public Integer[] excute() {
        int date = visitDateController();
        Map<String, Integer> orderedMenu = orderMenuController();
        int totalOrderAmount = totalOrderCalculator(orderedMenu);

        int discountWeekQuantity = DiscountWeek.calculateDiscountedOrderQuantity(orderedMenu, date); // 평일 혹은 주말 할인에 적용되는 음식 개수
        int orderedChampagneCount = orderedMenu.get(MenuInfo.CHAMPAGNE.getName());
        return new Integer[]{date, totalOrderAmount, discountWeekQuantity, orderedChampagneCount};
    }

    private static int visitDateController() {
        VisitDate visitDate = new VisitDate();
        int date = INITIALIZE_ZERO.getValue();
        while (date == INITIALIZE_ZERO.getValue()) {
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
        OutputView.print(EXPECTED_EVENT.getMessage());
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
