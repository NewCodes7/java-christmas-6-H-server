package christmas.model.customer;

import christmas.constant.ErrorMessage;
import christmas.constant.MenuInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderMenu {

    public Map<String, Integer> setOrderMenu(String input) {
        Map<String, Integer> orderedMenu = new HashMap<>();
        String[] splitInput = splitByComma(input);
        validate(splitInput);
        for (String item : splitInput) {
            String[] parts = item.split("-");
            orderedMenu.put(parts[0], Integer.parseInt(parts[1]));
        }
        return orderedMenu;
    }

    private String[] splitByComma(String input) {
        return input.split(",");
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    private void validateValidMenu(String[] parts) {
        if (!MenuInfo.contains(parts[0])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_MENU.getMessage());
        }
    }

    private void validateOrderQuantity(String[] parts) {
        try {
            if (Integer.parseInt(parts[1]) < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getErrorMessage()
                    + ErrorMessage.INVALID_ORDER_QUANTITY.getMessage());
        }
    }

    private int validateTotalOrderQuantityUnderLimit(String[] parts, int count) {
        count += Integer.parseInt(parts[1]);
        if (count > 20) {
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
