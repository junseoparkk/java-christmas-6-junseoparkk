package christmas.model.event;

import static christmas.model.event.EventCategory.CHRISTMAS_DAY_DISCOUNT;
import static christmas.model.event.EventCategory.GIVEAWAY_EVENT;
import static christmas.model.event.EventCategory.SPECIAL_DISCOUNT;
import static christmas.model.event.EventCategory.WEEK_DAY_DISCOUNT;
import static christmas.model.event.EventCategory.WEEK_END_DISCOUNT;
import static org.assertj.core.api.Assertions.*;

import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventBenefitTest {
    @DisplayName("총주문 금액이 10,000원을 넘어가지 않으면 이벤트가 적용되지 않아야 한다.")
    @Test
    void testNotApplyEventByUnderStandardPrice() {
        //given
        int date = 3;
        String menu = "타파스-1,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        Map<EventCategory, Boolean> benefits = eventBenefit.applyEvent();

        //then
        assertThat(benefits.entrySet().stream()
                .noneMatch(v -> v.getValue()))
                .isTrue();
    }

    @DisplayName("크리스마스 디데이 할인 기간에 주문하면 크리스마스 디데이 할인 정책을 적용해야 한다.")
    @Test
    void testEventByChristmasDayDiscountSeasonOrder() {
        //given
        int date = 25;
        String menu = "타파스-2,티본스테이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        boolean isAppliedEvent = eventBenefit.findAppliedEventFrom(CHRISTMAS_DAY_DISCOUNT);

        //then
        assertThat(isAppliedEvent).isTrue();
    }

    @DisplayName("평일에 주문하면 크리스마스 평일 할인 정책을 적용해야 한다.")
    @Test
    void testEventByWeekdayOrder() {
        //given
        int date = 4;
        String menu = "타파스-2,티본스테이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        boolean isAppliedWeekdayEvent = eventBenefit.findAppliedEventFrom(WEEK_DAY_DISCOUNT);
        boolean isAppliedWeekendEvent = eventBenefit.findAppliedEventFrom(WEEK_END_DISCOUNT);

        //then
        assertThat(isAppliedWeekdayEvent).isTrue();
        assertThat(isAppliedWeekendEvent).isFalse();
    }

    @DisplayName("주말에 주문하면 크리스마스 주말 할인 정책을 적용해야 한다.")
    @Test
    void testEventByWeekendOrder() {
        //given
        int date = 1;
        String menu = "타파스-2,티본스테이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        boolean isAppliedWeekdayEvent = eventBenefit.findAppliedEventFrom(WEEK_DAY_DISCOUNT);
        boolean isAppliedWeekendEvent = eventBenefit.findAppliedEventFrom(WEEK_END_DISCOUNT);

        //then
        assertThat(isAppliedWeekdayEvent).isFalse();
        assertThat(isAppliedWeekendEvent).isTrue();
    }

    @DisplayName("특별 할인 기간에 주문하면 특별 할인 정책을 적용해야 한다.")
    @Test
    void testEventBySpecialDateOrder() {
        int date = 25;
        String menu = "타파스-2,티본스테이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        boolean isAppliedEvent = eventBenefit.findAppliedEventFrom(SPECIAL_DISCOUNT);

        //then
        assertThat(isAppliedEvent).isTrue();
    }

    @DisplayName("할인 전 총주문 금액이 12만 원 이상이면 증정 이벤트 정책을 적용해야 한다.")
    @Test
    void testEventByTotalOrderPrice() {
        int date = 25;
        String menu = "타파스-2,티본스테이크-2,레드와인-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        boolean isAppliedEvent = eventBenefit.findAppliedEventFrom(GIVEAWAY_EVENT);

        //then
        assertThat(isAppliedEvent).isTrue();
    }

    //1.크리스마스 디데이 할인 2.평일 할인 3.특별 할인 4.증정 이벤트 적용
    @DisplayName("크리스마스에 120,000원 이상 주문하면 중복된 할인과 증정이 허용된다.")
    @Test
    void testEventByChristmasDay() {
        int date = 25;
        String menu = "타파스-2,티본스테이크-2,레드와인-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        Map<EventCategory, Boolean> benefits = eventBenefit.applyEvent();

        //then
        assertThat(benefits.values().stream()
                .filter(value -> value)
                .count())
                .isEqualTo(4);
    }
}
