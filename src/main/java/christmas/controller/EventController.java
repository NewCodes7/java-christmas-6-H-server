package christmas.controller;

import christmas.model.event.DiscountChristmasDDay;
import christmas.model.event.DiscountSpecial;
import christmas.model.event.DiscountWeek;
import christmas.model.event.GiftPromotion;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {

    public void excute(Integer[] data) {
        int date = data[0];
        int totalOrderAmount = data[1];
        int discountWeekQuantity = data[2]; //Map으로 하는 게 더 안정적이긴 할 듯.

        // event - 할인 및 증정 내역 출력
        int giftPrice = giftPromotionController(totalOrderAmount); // 0원일 수도 있음. (이벤트 미적용)

        int discountDDay = discountChristmasDDayConroller(date); // 0원일 수도 있음. (이벤트 미적용)
        int discountWeek = discountWeekConroller(discountWeekQuantity); // 디저트 혹은 메인 주문량 위해서 필요함.
        int discountSpecial = discountSpecialController(date); // 0원일 수도 있음. (이벤트 미적용)

        Integer[] discountDetails = {discountDDay, discountWeek, discountSpecial, giftPrice};
        OutputView.printDiscountDetails(discountDetails);

        int totalDiscount = OutputView.printTotalDiscount(discountDetails);
        OutputView.printFinalPayment(totalOrderAmount, discountDetails);
        OutputView.printEventBadge(totalDiscount);
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
        OutputView.printGift(giftPrice);
        return giftPrice;
    }
}
