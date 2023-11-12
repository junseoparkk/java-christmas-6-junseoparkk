package christmas.model.order;

import static christmas.model.menu.MenuCategory.APPETIZER;
import static christmas.model.menu.MenuCategory.BEVERAGE;
import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.menu.MenuCategory.MAIN;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @DisplayName("예약 전날의 날짜를 반환해야 한다.")
    @Test
    void testCalculatePreviousDate() {
        //given
        int date = 23;
        OrderLineItems items = new OrderLineItems("시저샐러드-2");
        Order order = new Order(date, items);

        //when
        int previousDate = order.calculatePreviousDate();

        //then
        assertThat(previousDate).isEqualTo(22);
    }

    @DisplayName("주문 메뉴에서 카테고리별 메뉴의 주문 수량 총합을 반환해야 한다.")
    @Test
    void testCountMenuByCategory() {
        //given
        int date = 23;
        String menus = "양송이수프-4,바비큐립-5,해산물파스타-2,초코케이크-1,아이스크림-1,제로콜라-3";
        OrderLineItems items = new OrderLineItems(menus);
        Order order = new Order(date, items);

        //when
        int appetizerCount = order.countMenuQuantityByCategory(APPETIZER);
        int mainCount = order.countMenuQuantityByCategory(MAIN);
        int dessertCount = order.countMenuQuantityByCategory(DESSERT);
        int beverageCount = order.countMenuQuantityByCategory(BEVERAGE);

        //then
        assertThat(appetizerCount).isEqualTo(4);
        assertThat(mainCount).isEqualTo(7);
        assertThat(dessertCount).isEqualTo(2);
        assertThat(beverageCount).isEqualTo(3);

    }

    @DisplayName("총주문 금액을 계산하여 반환해야 한다.")
    @Test
    void testCalculateTotalOrderPrice() {
        //given
        int date = 1;
        String menus = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menus));

        //when
        int totalOrderPrice = order.calculateTotalOrderPrice();

        //then
        assertThat(totalOrderPrice).isEqualTo(142000);
    }
}
