package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.EventBadge;
import christmas.constant.Message;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_ORDER_AMOUNTS = "<할인 전 총주문 금액>";
    private static final String GIFT = "<증정 메뉴>";
    private static final String BENEFITS_DETAILS = "<혜택 내역>";
    private static final String TOTAL_BENEFITS_AMOUNTS = "<총혜택 금액>";
    private static final String TOTAL_PAYMENTS = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE = "<12월 이벤트 배지>";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWithNewLine(String message) {
        System.out.println("\n" + message);
    }

    public static void printOrderedMenu(Map<String, Integer> orderedMenu) {
        printWithNewLine(ORDER_MENU);
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            String formattedLine = String.format("%s %d개", menuName, quantity);
            System.out.println(formattedLine);
        }
    }

    public static void printTotalOrderAmount(int amount) {
        printWithNewLine(TOTAL_ORDER_AMOUNTS);

        System.out.println(formatCurrency(amount));
    }

    private static String formatCurrency(int amount) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###원");
        return currencyFormatter.format(amount);
    }

    public static void printGift(int giftPrice) {
        printWithNewLine(GIFT);
        String message = "없음";
        if (giftPrice == 25000) {
            message = "샴페인 1개";
        }
        System.out.println(message);
    }

    public static void printDiscountDetails(Integer[] details) {
        printWithNewLine(BENEFITS_DETAILS);
        String[] message = {"크리스마스 디데이 할인: ", "평일 할인: ", "특별 할인: ", "증정 이벤트: "};
        for (int i = 0; i<message.length; i++) {
            if (details[i] != 0) {
                System.out.println(message[i] + "-" + formatCurrency(details[i]));
            }
        }
        if (Arrays.stream(details).allMatch(number -> number == 0)) {
            System.out.println("없음");
        }
    }

    public static int printTotalDiscount(Integer[] details) {
        printWithNewLine(TOTAL_BENEFITS_AMOUNTS);

        int totalDiscount = 0;
        for (int amount : details) {
            totalDiscount += amount;
        }
        System.out.println("-" + formatCurrency(totalDiscount));
        return totalDiscount;
    }

    public static void printFinalPayment(int totalAmount, Integer[] discountAmounts) {
        printWithNewLine(TOTAL_PAYMENTS);

        int finalPayment = totalAmount;
        for (int i = 0; i<3; i++) {
            finalPayment -= discountAmounts[i];
        }
        System.out.println(formatCurrency(finalPayment));
    }

    public static void printEventBadge(int totalDiscount) {
        printWithNewLine(DECEMBER_EVENT_BADGE);
        if (totalDiscount < 5000) {
            System.out.println("없음");
        }
        if (totalDiscount >= 5000 && totalDiscount < 10000) {
            System.out.println("별");
        }
        if (totalDiscount >= 10000 && totalDiscount < 20000) {
            System.out.println("트리");
        }
        if (totalDiscount >= 20000) {
            System.out.println("산타");
        }
    }

    public static void lineBreak() {
        System.out.print("\n");
    }
}
