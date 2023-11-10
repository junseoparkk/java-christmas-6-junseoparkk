package christmas.exception;

public class InvalidDateException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해주세요.";

    public InvalidDateException() {
        super(MESSAGE);
    }
}