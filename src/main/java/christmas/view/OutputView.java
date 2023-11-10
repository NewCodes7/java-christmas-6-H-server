package christmas.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class OutputView {

    public static void printOrderedMenu(Map<String, Integer> orderedMenu) {
        lineBreak();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            String formattedLine = String.format("%s %d개", menuName, quantity);
            System.out.println(formattedLine);
        }
    }

    public static void printTotalOrderAmount(int amount) {
        lineBreak();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatCurrency(amount));
    }

    private static String formatCurrency(int amount) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###원");
        return currencyFormatter.format(amount);
    }

    public static void printGift(int giftPrice) {
        lineBreak();
        System.out.println("<증정 메뉴>");
        String message = "없음";
        if (giftPrice == 25000) {
            message = "샴페인 1개";
        }
        System.out.println(message);
    }

    public static void printDiscountDetails(Integer[] details) {
        lineBreak();
        System.out.println("<혜택 내역>");
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

    public static void lineBreak() {
        System.out.print("\n");
    }
}
