package christmas.model.event;

import static org.assertj.core.api.Assertions.*;

import christmas.model.event.policy.ChristmasDayDiscountPolicy;
import christmas.model.event.policy.DiscountPolicy;
import christmas.model.event.policy.GiveawayEventPolicy;
import christmas.model.event.policy.SpecialDiscountPolicy;
import christmas.model.event.policy.WeekdayDiscountPolicy;
import christmas.model.event.policy.WeekendDiscountPolicy;
import christmas.model.menu.MenuItem;
import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest {
    //ChristmasDayDiscountPolicy
    @DisplayName("크리스마스 디데이 할인 정책의 초기 할인 금액은 1,000원이어야 한다..")
    @Test
    void testChristmasDayDiscountPolicyByFirstDate() {
        //given
        int date = 1;
        OrderLineItems menus = new OrderLineItems("타파스-1");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new ChristmasDayDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(1000);
    }

    @DisplayName("크리스마스 디데이 할인은 1,000원으로 시작하여 날마다 할인 금액이 100원씩 증가해야 한다.")
    @Test
    void testChristmasDayDiscountPolicy() {
        //given
        int date = 25;
        OrderLineItems menus = new OrderLineItems("타파스-1");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new ChristmasDayDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(3400);
    }

    //WeekdayDiscountPolicy
    @DisplayName("디저트 메뉴가 없다면 평일 할인 금액은 0원이어야 한다..")
    @Test
    void testWeekdayDiscountPolicyByNoneDessert() {
        //given
        int date = 4;
        OrderLineItems menus = new OrderLineItems("시저샐러드-2,티본스테이크-1,바비큐립-1,제로콜라-3");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new WeekdayDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(0);
    }

    @DisplayName("평일 할인은 디저트 메뉴 1개당 2023원 할인되어야 한다.")
    @Test
    void testWeekdayDiscountPolicy() {
        //given
        int date = 4;
        OrderLineItems menus = new OrderLineItems("티본스테이크-1,바비큐립-1,초코케이크-2,아이스크림-2");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new WeekdayDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(8092);
    }

    //WeekendDiscountPolicy
    @DisplayName("메인 메뉴가 없다면 주말 할인 금액은 0원이어야 한다..")
    @Test
    void testWeekendDiscountPolicyByNoneMain() {
        //given
        int date = 4;
        OrderLineItems menus = new OrderLineItems("시저샐러드-2,초코케이크-2,레드와인-1");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(0);
    }

    @DisplayName("주말 할인은 메인 메뉴 1개당 2023원 할인되어야 한다.")
    @Test
    void testWeekendDiscountPolicy() {
        //given
        int date = 4;
        OrderLineItems menus = new OrderLineItems("티본스테이크-1,바비큐립-2,초코케이크-2,아이스크림-2");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(6069);
    }

    //SpecialDiscountPolicy
    @DisplayName("특별 할인 날짜가 아니라면 특별 할인 금액은 0원이어야 한다.")
    @Test
    void testSpecialDiscountPolicyWhenNotSpecialDay() {
        //given
        int date = 4;
        OrderLineItems menus = new OrderLineItems("시저샐러드-2,초코케이크-2,레드와인-1");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new SpecialDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(0);
    }

    @DisplayName("특별 할인 날짜라면 특별 할인 금액은 1,000원이어야 한다.")
    @Test
    void testSpecialDiscountPolicy() {
        //given
        int date = 3;
        OrderLineItems menus = new OrderLineItems("시저샐러드-2,초코케이크-2,레드와인-1");
        Order order = new Order(date, menus);
        DiscountPolicy discountPolicy = new SpecialDiscountPolicy();

        //when
        int discountAmount = calculateDiscountAmount(order, discountPolicy);

        //then
        assertThat(discountAmount).isEqualTo(1000);
    }

    //GiveawayEventPolicy
    @DisplayName("할인 전 총주문 금액이 12만 원 이상이라면, 샴페인 1개를 증정해야 한다.")
    @Test
    void testGiveawayEventPolicy() {
        //given
        int date = 3;
        OrderLineItems menus = new OrderLineItems("시저샐러드-2,바비큐립-3,레드와인-1");
        Order order = new Order(date, menus);
        GiveawayEventPolicy giveawayEventPolicy = new GiveawayEventPolicy();

        //when
        int discountAmount = giveawayEventPolicy.calculateDiscountAmount(order);
        MenuItem item = giveawayEventPolicy.giveawayItem(order);

        //then
        assertThat(item).isEqualTo(MenuItem.CHAMPAGNE);
        assertThat(discountAmount).isEqualTo(item.getPrice());
    }

    private int calculateDiscountAmount(Order order, DiscountPolicy discountPolicy) {
        return discountPolicy.calculateDiscountAmount(order);
    }
}
