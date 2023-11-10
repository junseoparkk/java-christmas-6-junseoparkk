package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.model.order.OrderLineItems;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderValidatorTest {
    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"크림수프", "까르보나라파스타", "녹차아이스크림", "코카콜라"})
    void testExceptionByNotExistName(String name) {
        //given
        int quantity = 3;

        //when, then
        assertThatThrownBy(() -> OrderValidator.validateOrderLineItem(name, quantity));
    }

    @DisplayName("메뉴판에 존재하는 메뉴를 주문하면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "크리스마스파스타", "아이스크림", "제로콜라"})
    void testNoneExceptionByExistName(String name) {
        //given
        int quantity = 3;

        //when, then
        assertDoesNotThrow(() -> OrderValidator.validateOrderLineItem(name, quantity));
    }

    @DisplayName("하나의 메뉴를 1개 이상 주문하지 않으면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    void testExceptionByNotOverOneQuantity(int quantity) {
        //given
        String name = "제로콜라";

        //when, then
        assertThatThrownBy(() -> OrderValidator.validateOrderLineItem("제로콜라", quantity));
    }

    @DisplayName("하나의 메뉴를 1개 이상 주문하면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10})
    void testNoneExceptionByOverOneQuantity(int quantity) {
        //given
        String name ="제로콜라";

        //when, then
        assertDoesNotThrow(() -> OrderValidator.validateOrderLineItem(name, quantity));
    }

    @DisplayName("음료만 주문하면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1", "레드와인-2", "샴페인-3"})
    void testExceptionByOnlyBeverageOrder(String item) {
        //when, then
        assertThatThrownBy(() -> new OrderLineItems(item));
    }

    @DisplayName("음료가 아닌 다른 메뉴만 주문하면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1", "바비큐립-2", "아이스크림-3"})
    void testNoneExceptionByOnlyOtherOrder(String item) {
        //when, then
        assertDoesNotThrow(() -> new OrderLineItems(item));
    }

    @DisplayName("주문에 음료만 있는 것이 아니라면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-3,제로콜라-1", "크리스마스파스타-1,아이스크림-1,레드와인-2", "초코케이크-2,샴페인-3"})
    void testNoneExceptionByValidOrder(String item) {
        //when, then
        assertDoesNotThrow(() -> new OrderLineItems(item));
    }

    @DisplayName("중복된 메뉴를 주문하면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,제로콜라-2", "양송이수프-1,레드와인-2,양송이수프-1"})
    void testExceptionByDuplicatedOrder(String item) {
        //when, then
        assertThatThrownBy(() -> new OrderLineItems(item));
    }

    @DisplayName("주문에 중복된 메뉴가 없다면 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-3,제로콜라-1", "크리스마스파스타-1,아이스크림-1,레드와인-2", "초코케이크-2,샴페인-3"})
    void testNoneExceptionByNotDuplicatedOrder(String item) {
        //when, then
        assertDoesNotThrow(() -> new OrderLineItems(item));
    }
}
