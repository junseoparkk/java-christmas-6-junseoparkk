package christmas.validator;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;

public class InputValidator {
    private static final int FIRST_DATE = 1;
    private static final int THIRTY_ONE_DATE = 31;
    private static final String ORDER_FORM_REGEX = "^([가-힣]+-\\d+)(?:,[가-힣]+-\\d+)*$";

    private InputValidator() {
    }

    public static void validateDateForm(final String date) {
        validateIsDigit(date);
        validateDateRage(date);
    }

    public static void validateOrderForm(final String order) {
        if (isNotMatchValidOrderForm(order)) {
            throw new InvalidOrderException();
        }
    }

    private static void validateIsDigit(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new InvalidDateException();
        }
    }

    private static void validateDateRage(String date) {
        int numberDate = Integer.parseInt(date);
        if (numberDate < FIRST_DATE) {
            throw new InvalidDateException();
        }
        if (THIRTY_ONE_DATE < numberDate) {
            throw new InvalidDateException();
        }
    }

    private static boolean isNotMatchValidOrderForm(String order) {
        return !order.matches(ORDER_FORM_REGEX);
    }
}
