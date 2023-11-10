package christmas.validator;

import christmas.exception.InvalidDateInputException;

public class InputValidator {
    private static final int FIRST_DATE = 1;
    private static final int THIRTY_ONE_DATE = 31;

    private InputValidator() {
    }

    public static void validateDate(final String date) {
        validateIsDigit(date);
        validateDateRage(date);
    }

    private static void validateIsDigit(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new InvalidDateInputException();
        }
    }

    private static void validateDateRage(String date) {
        int numberDate = Integer.parseInt(date);
        if (numberDate < FIRST_DATE) {
            throw new InvalidDateInputException();
        }
        if (THIRTY_ONE_DATE < numberDate) {
            throw new InvalidDateInputException();
        }
    }
}
