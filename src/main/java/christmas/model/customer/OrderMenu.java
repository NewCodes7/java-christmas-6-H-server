package christmas.model.customer;

import christmas.constant.ErrorMessage;
import christmas.constant.MenuInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderMenu {
    private static final int INITIALIZE_ZERO = 0;
    private static final int MAX_TOTAL_ORDER_LIMIT = 20;
    private static final int MIN_ORDER_LIMIT = 1;
    private static final int VALID_LENGTH = 2;
    private static final int INDEX_ORDERED_MENU = 0;
    private static final int INDEX_ORDERED_QUANTITY = 1;
    private static final String ORDER_HYPHEN = "-";
    private static final String ORDER_COMMA = ",";

    public Map<String, Integer> setOrderMenu(String input) {
        Map<String, Integer> orderedMenu = new HashMap<>();
        String[] splitInput = splitByComma(input);
        validate(splitInput);
        for (String item : splitInput) {
            String[] parts = item.split(ORDER_HYPHEN);
            orderedMenu.put(parts[INDEX_ORDERED_MENU], Integer.parseInt(parts[INDEX_ORDERED_QUANTITY]));
        }
        return orderedMenu;
    }

    private String[] splitByComma(String input) {
        return input.split(ORDER_COMMA);
    }

    private void validate(String[] input) {
        int totalOrderQuantity = INITIALIZE_ZERO;
        Set<String> menuChoices = new HashSet<>();
        for (String item : input) {
            String[] parts = item.split(ORDER_HYPHEN);
            menuChoices.add(parts[INDEX_ORDERED_MENU]);

            validateValidHyphenFormat(parts);
            validateValidMenu(parts);
            validateOrderQuantity(parts);
            totalOrderQuantity = validateTotalOrderQuantityUnderLimit(parts, totalOrderQuantity);
        }
        validateNotOnlyDrinks(menuChoices);
    }

    private void validateValidHyphenFormat(String[] parts) {
        if (parts.length != VALID_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private void validateValidMenu(String[] parts) {
        if (!MenuInfo.contains(parts[INDEX_ORDERED_MENU])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_MENU.getMessage());
        }
    }

    private void validateOrderQuantity(String[] parts) {
        try {
            if (Integer.parseInt(parts[INDEX_ORDERED_QUANTITY]) < MIN_ORDER_LIMIT) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_QUANTITY.getMessage());
        }
    }

    private int validateTotalOrderQuantityUnderLimit(String[] parts, int count) {
        count += Integer.parseInt(parts[INDEX_ORDERED_QUANTITY]);
        if (count > MAX_TOTAL_ORDER_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_LIMIT.getMessage());
        }
        return count;
    }

    private void validateNotOnlyDrinks(Set<String> menuChoices) {
        for(String drink : MenuInfo.getDrinkNames()) {
            menuChoices.remove(drink);
        }
        if (menuChoices.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_DRINK.getMessage());
        }
    }
}
