package christmas.controller;

import christmas.constant.Message;
import christmas.model.event.DiscountChristmasDDay;
import christmas.model.event.DiscountSpecial;
import christmas.model.event.DiscountWeek;
import christmas.model.event.GiftPromotion;
import christmas.model.customer.OrderMenu;
import christmas.model.TotalOrderCalculator;
import christmas.model.customer.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class MainController {
    public void excute() {
        OutputView.print(Message.WELCOME.getMessage());

        int date = visitDateController();
        Map<String, Integer> orderedMenu = orderMenuController();
        int discountDDay = discountChristmasDDayConroller(date); // 0원일 수도 있음. (이벤트 미적용)
        int discountWeek = discountWeekConroller(orderedMenu, date);
        int discountSpecial = discountSpecialController(date); // 0원일 수도 있음. (이벤트 미적용)

        int totalOrderAmount = totalOrderCalculator(orderedMenu);
        int giftPrice = giftPromotionController(totalOrderAmount); // 0원일 수도 있음. (이벤트 미적용)

        OutputView.print(Message.EXPECTED_EVENT.getMessage());
        OutputView.printOrderedMenu(orderedMenu);
        OutputView.printTotalOrderAmount(totalOrderAmount);
        OutputView.printGift(giftPrice);
        Integer[] discountDetails = {discountDDay, discountWeek, discountSpecial, giftPrice};
        OutputView.printDiscountDetails(discountDetails);
        int totalDiscount = OutputView.printTotalDiscount(discountDetails);
        OutputView.printFinalPayment(totalOrderAmount, discountDetails);
        OutputView.printEventBadge(totalDiscount);
    }

    private static int visitDateController() {
        VisitDate visitDate = new VisitDate();
        int date = 0;
        while (date == 0) {
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

    private static int giftPromotionController(int totalOrderAmount) {
        GiftPromotion giftPromotion = new GiftPromotion();
        return giftPromotion.setGift(totalOrderAmount);
    }

    private static int totalOrderCalculator(Map<String, Integer> orderedMenu) {
        TotalOrderCalculator totalOrderCalculator = new TotalOrderCalculator();
        return totalOrderCalculator.calculateTotalOrder(orderedMenu);
    }
}
