package christmas.model.customer;

import christmas.constant.ErrorMessage;
import christmas.constant.Numbers;
import java.util.Arrays;

public class VisitDate {
    public static final int DECEMBER_FIRST = 1;
    public static final int DECEMBER_LAST = 31;
    public static final int REFERENCE_FRIDAY = 1;
    public static final int REFERENCE_SATURDAY = 2;
    private static int date;

    public int setVisitDate(String number) {
        validate(number);
        date = Integer.parseInt(number);
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

    public static boolean isWeekend() {
        Integer[] weekend = {REFERENCE_FRIDAY, REFERENCE_SATURDAY};
        return Arrays.asList(weekend).contains(date % Numbers.WEEK_LENGTH.getValue());
    }
}
