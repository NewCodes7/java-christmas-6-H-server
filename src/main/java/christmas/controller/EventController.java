package christmas.controller;

import christmas.model.event.DiscountChristmasDDay;
import christmas.model.event.DiscountSpecial;
import christmas.model.event.DiscountWeek;
import christmas.model.event.GiftPromotion;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {

    public void excute(Integer[] data) {
        int totalOrderAmount = data[1];
        Integer[] discountDetails = excuteDiscountResult(data);
        excuteFinalResult(discountDetails, totalOrderAmount);
    }

    private static Integer[] excuteDiscountResult(Integer[] data) {
        int date = data[0];
        int totalOrderAmount = data[1];
        int discountWeekQuantity = data[2];

        int giftPrice = giftPromotionController(totalOrderAmount);
        int discountDDay = discountChristmasDDayConroller(date);
        int discountWeek = discountWeekConroller(discountWeekQuantity);
        int discountSpecial = discountSpecialController(date);
        Integer[] discountDetails = {discountDDay, discountWeek, discountSpecial, giftPrice};

        return discountDetails;
    }

    private static void excuteFinalResult(Integer[] discountDetails, int totalOrderAmount) {
        int totalDiscount = calculateTotalDiscounted(discountDetails);
        OutputView.printDiscountDetails(discountDetails);
        calculateFinalPayment(totalOrderAmount, discountDetails);
        checkEventBadge(totalDiscount);
    }

    private static int discountChristmasDDayConroller(int date) {
        DiscountChristmasDDay discountChristmasDDay = new DiscountChristmasDDay();
        return discountChristmasDDay.calculate(date);
    }

    private static int discountWeekConroller(int quantity) {
        DiscountWeek discountWeek = new DiscountWeek();
        return discountWeek.setDiscount(quantity);
    }

    private static int discountSpecialController(int date) {
        DiscountSpecial discountSpecial = new DiscountSpecial();
        return discountSpecial.setDiscount(date);
    }

    private static int giftPromotionController(int totalOrderAmount) {
        GiftPromotion giftPromotion = new GiftPromotion();
        int giftPrice = giftPromotion.setGift(totalOrderAmount);
        String message = "없음";
        if (giftPrice == 25000) {
            message = "샴페인 1개";
        }
        OutputView.printGift(message);
        return giftPrice;
    }

    private static void checkEventBadge(int totalDiscount) {
        String badge = "없음";
        if (totalDiscount >= 5000 && totalDiscount < 10000) {
            badge = "별";
        }
        if (totalDiscount >= 10000 && totalDiscount < 20000) {
            badge = "트리";
        }
        if (totalDiscount >= 20000) {
            badge = "산타";
        }
        OutputView.printEventBadge(badge);
    }

    private static int calculateTotalDiscounted(Integer[] details) {
        int totalDiscount = 0;
        for (int amount : details) {
            totalDiscount += amount;
        }
        OutputView.printTotalDiscount(totalDiscount);
        return totalDiscount;
    }

    private static void calculateFinalPayment(int totalAmount, Integer[] discountAmounts) {
        int finalPayment = totalAmount;
        for (int i = 0; i<3; i++) {
            finalPayment -= discountAmounts[i];
        }
        OutputView.printFinalPayment(finalPayment);
    }
}
