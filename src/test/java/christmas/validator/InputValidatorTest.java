package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    //방문 날짜 검증 테스트
    @DisplayName("방문할 날짜가 숫자가 아니라면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가", "1가", "a1", " ", ""})
    void testExceptionByNotNumberFormatDate(String date) {
        //when, then
        assertThatThrownBy(() -> InputValidator.validateDateForm(date))
                .isInstanceOf(InvalidDateException.class);
    }

    @DisplayName("방문할 날짜가 1~31 사이의 숫자가 아니라면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "32"})
    void testExceptionByNotValidDateRange(String date) {
        //when, then
        assertThatThrownBy(() -> InputValidator.validateDateForm(date))
                .isInstanceOf(InvalidDateException.class);
    }

    @DisplayName("방문할 날짜가 1~31 사이의 숫자라면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "11", "21", "30", "31"})
    void testValidDate(String date) {
        //when, then
        assertDoesNotThrow(() -> InputValidator.validateDateForm(date));
    }

    /*
     * 주문 메뉴 형식 검증 테스트
     * e.g.) 해산물파스타-2,레드와인-1,초코케이크-1
     * e.g.) 메뉴명1-수량1,메뉴명2-수량2 형식
     */
    @DisplayName("주문 메뉴 형식이 예시와 다른 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-2,",
            ",해산물파스타-2",
            "해산물파스타",
            "해산물파스타-",
            "해산물파스타-2,초코케이크",
            "해산물파스타-2.초코케이크-1",
            "해산물파스타:2,초코케이크:1",
            " ",
            "",
    })
    void testExceptionByNotValidOrderForm(String order) {
        //when, then
        assertThatThrownBy(() -> InputValidator.validateOrderForm(order))
                .isInstanceOf(InvalidOrderException.class);
    }

    @DisplayName("주문 형식이 예시와 같다면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-2,레드와인-1,초코케이크-1",
            "해산물파스타-2,레드와인-1",
            "해산물파스타-2",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"
    })
    void testValidOrderForm(String order) {
        //when, then
        assertDoesNotThrow(() -> InputValidator.validateOrderForm(order));
    }
}
