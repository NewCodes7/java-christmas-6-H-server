package christmas.model.customer;

import static christmas.constant.ErrorMessage.INVALID_ORDER;
import static christmas.constant.ErrorMessage.INVALID_ORDER_DRINK;
import static christmas.constant.ErrorMessage.INVALID_ORDER_LIMIT;
import static christmas.constant.ErrorMessage.INVALID_ORDER_QUANTITY;
import static christmas.constant.ErrorMessage.INVALID_ORDER_UNIQUE_MENU;
import static christmas.constant.event.EventNumbers.MAX_TOTAL_ORDER_LIMIT;

import christmas.constant.ErrorMessage;
import christmas.constant.event.EventNumbers;
import christmas.constant.MenuInfo;
import christmas.constant.Numbers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderMenu {
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

    private void validate(String[] ordered) {
        int totalOrderQuantity = Numbers.INITIALIZE_ZERO.getValue();
        Set<String> menuChoices = new HashSet<>();
        for (String item : ordered) {
            String[] parts = item.split(ORDER_HYPHEN);
            menuChoices.add(parts[INDEX_ORDERED_MENU]);
            validateValidHyphenFormat(parts);
            validateValidMenu(parts);
            validateOrderQuantity(parts);
            totalOrderQuantity = validateTotalOrderQuantityUnderLimit(parts, totalOrderQuantity);
        }
        validateNotOnlyDrinks(menuChoices);
        validateIsMenuUnique(ordered, menuChoices);
    }

    private void validateValidHyphenFormat(String[] parts) {
        if (parts.length != VALID_LENGTH) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private void validateValidMenu(String[] parts) {
        if (!MenuInfo.contains(parts[INDEX_ORDERED_MENU])) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_MENU.getMessage());
        }
    }

    private void validateOrderQuantity(String[] parts) {
        try {
            if (Integer.parseInt(parts[INDEX_ORDERED_QUANTITY]) < EventNumbers.MIN_ORDER_LIMIT.getValue()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + INVALID_ORDER_QUANTITY.getMessage());
        }
    }

    private int validateTotalOrderQuantityUnderLimit(String[] parts, int count) {
        count += Integer.parseInt(parts[INDEX_ORDERED_QUANTITY]);
        if (count > MAX_TOTAL_ORDER_LIMIT.getValue()) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + INVALID_ORDER_LIMIT.getMessage());
        }
        return count;
    }

    private void validateNotOnlyDrinks(Set<String> menuChoices) {
        Set<String> menuChoicesCopy = new HashSet<>(menuChoices);
        for(String drink : MenuInfo.getDrinkNames()) {
            menuChoicesCopy.remove(drink);
        }
        if (menuChoicesCopy.isEmpty()) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + INVALID_ORDER_DRINK.getMessage());
        }
    }

    private void validateIsMenuUnique(String[] ordered, Set<String> menuChoices) {
        if(ordered.length != menuChoices.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage()
                    + INVALID_ORDER_UNIQUE_MENU.getMessage());
        }
    }
}
