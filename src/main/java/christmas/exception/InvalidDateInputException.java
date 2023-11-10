package christmas.exception;

public class InvalidDateInputException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해주세요.";

    public InvalidDateInputException() {
        super(MESSAGE);
    }
}
