package christmas.model.customer;

import christmas.constant.ErrorMessage;

public class VisitDate {
    public int setVisitDate(String number) {
        validate(number);
        int date = Integer.parseInt(number);
        return date;
    }

    private static void validate(String date) {
        validateIsInRange(date);
    }

    private static void validateIsInRange(String date) {
        try{
            int number = Integer.parseInt(date);
            if (number < 1 || number > 31) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_DATE.getErrorMessage());
        }
    }
}
