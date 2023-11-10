package christmas.model;

import christmas.constant.MenuInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderMenu {
    private static Map<String, Integer> orderedMenu = new HashMap<>();
    public OrderMenu(String input) {
        String[] splitInput = splitByComma(input);
        validate(splitInput);
        setOrderedMenu(splitInput);
    }

    private String[] splitByComma(String input) {
        return input.split(",");
    }

    private void setOrderedMenu(String[] input) {
        for (String item : input) {
            String[] parts = item.split("-");
            orderedMenu.put(parts[0], Integer.parseInt(parts[1]));
        }
    }

    private void validate(String[] input) {
        int totalOrderQuantity = 0;
        Set<String> menuChoices = new HashSet<>();
        for (String item : input) {
            String[] parts = item.split("-");
            menuChoices.add(parts[0]);

            validateValidHyphenFormat(parts);
            validateValidMenu(parts);
            validateOrderQuantity(parts);
            totalOrderQuantity = validateTotalOrderQuantityUnderLimit(parts, totalOrderQuantity);
        }
        validateNotOnlyDrinks(menuChoices);
    }

    private void validateValidHyphenFormat(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n예시 주문 형식을 참고해주세요.");
        }
    }

    private void validateValidMenu(String[] parts) {
        if (!MenuInfo.contains(parts[0])) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n우테코 식당에 존재하지 않는 메뉴입니다.");
        }
    }

    private void validateOrderQuantity(String[] parts) {
        try {
            if (Integer.parseInt(parts[1]) < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n 주문 수량은 1 이상의 숫자만 입력하셔야 합니다.");
        }
    }

    private int validateTotalOrderQuantityUnderLimit(String[] parts, int count) {
        count += Integer.parseInt(parts[1]);
        if (count > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n 총 주문 수량은 20개 이하여야 합니다.");
        }
        return count;
    }

    private void validateNotOnlyDrinks(Set<String> menuChoices) {
        for(String drink : MenuInfo.getDrinkNames()) {
            menuChoices.remove(drink);
        }
        if (menuChoices.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n음료만 주문할 수 없습니다.");
        }
    }
}
