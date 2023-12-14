package christmas.utils.validator;

public class InputValidator {
    private static final int MINIMUM_DAY = 1;
    private static final int MAXIMUM_DAY = 31;
    private static final String MENUS_INPUT_REGEX = "^([가-힣]+-\\d)+(?:,([가-힣]+-\\d)+)*$";

    private InputValidator() {
    }

    public static void validateVisitDay(final String day) {
        int date = validateIsDigit(day);
        validateDayRange(date);
    }

    public static void validateMenus(final String menus) {
        validateMenusForm(menus);
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

    private static void validateMenusForm(final String menus) {
        if (!menus.matches(MENUS_INPUT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.");
        }
    }
}
