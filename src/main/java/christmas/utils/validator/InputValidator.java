package christmas.utils.validator;

public class InputValidator {
    private static final int MINIMUM_DAY = 1;
    private static final int MAXIMUM_DAY = 31;

    private InputValidator() {
    }

    public static void validateVisitDay(final String day) {
        int date = validateIsDigit(day);
        validateDayRange(date);
    }

    private static int validateIsDigit(final String day) {
        try {
            return Integer.parseInt(day);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private static void validateDayRange(final int day) {
        if (day < MINIMUM_DAY) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 숫자만 입력해 주세요.");
        }
        if (day > MAXIMUM_DAY) {
            throw new IllegalArgumentException("[ERROR] 31 이하의 숫자만 입력해 주세요.");
        }
    }
}
