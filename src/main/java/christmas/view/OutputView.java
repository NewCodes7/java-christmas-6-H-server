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

    public static void printGift(String message) {
        printWithNewLine(GIFT);
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

    public static void printTotalDiscount(int totalDiscount) {
        printWithNewLine(TOTAL_BENEFITS_AMOUNTS);
        System.out.println("-" + formatCurrency(totalDiscount));
    }

    public static void printFinalPayment(int finalPayment) {
        printWithNewLine(TOTAL_PAYMENTS);
        System.out.println(formatCurrency(finalPayment));
    }

    public static void printEventBadge(String badge) {
        printWithNewLine(DECEMBER_EVENT_BADGE);
        System.out.println(badge);

    }

    public static void lineBreak() {
        System.out.print("\n");
    }
}
