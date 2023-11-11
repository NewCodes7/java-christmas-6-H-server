package christmas.model.customer;

import christmas.constant.ErrorMessage;

public class VisitDate {
    private static final int INITIALIZE_ZERO = 0;
    public static final int DECEMBER_FIRST = 1;
    public static final int DECEMBER_LAST = 31;

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
            if (number < DECEMBER_FIRST || number > DECEMBER_LAST) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_DATE.getErrorMessage());
        }
    }
}
