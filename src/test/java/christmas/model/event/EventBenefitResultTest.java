package christmas.model.event;

import static org.assertj.core.api.Assertions.*;

import christmas.model.badge.Badge;
import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventBenefitResultTest {
    @DisplayName("12월 이벤트 플래너 예시-1 혜택 금액 테스트")
    @Test
    void testEventBenefitResultPriceByExample1() {
        //given
        int date = 26;
        String menu = "타파스-1,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        EventBenefitResult eventBenefitResult = new EventBenefitResult(eventBenefit, order);
        eventBenefitResult.calculateEventBenefits();
        Map<EventCategory, Integer> result = eventBenefitResult.getAllEventResult();

        //then
        List<Integer> expected = List.of(0, 0, 0, 0, 0);
        List<Integer> target = result.values().stream().toList();

        assertThat(target).isEqualTo(expected);
    }

    @DisplayName("12월 이벤트 플래너 예시-2 혜택 금액 테스트")
    @Test
    void testEventBenefitResultPriceByExample2() {
        //given
        int date = 3;
        String menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        EventBenefitResult eventBenefitResult = new EventBenefitResult(eventBenefit, order);
        eventBenefitResult.calculateEventBenefits();
        Map<EventCategory, Integer> result = eventBenefitResult.getAllEventResult();

        //then
        List<Integer> expected = List.of(1200, 4046, 0, 1000, 25000);
        List<Integer> target = result.values().stream().toList();

        assertThat(target).isEqualTo(expected);
    }

    @DisplayName("12월 이벤트 플래너 예시-2 혜택 결과 테스트")
    @Test
    void testEventBenefitResultByExample2() {
        //given
        int date = 3;
        String menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        EventBenefitResult eventBenefitResult = new EventBenefitResult(eventBenefit, order);
        eventBenefitResult.calculateEventBenefits();
        eventBenefitResult.getAllEventResult();

        //then
        int totalBenefitPrice = eventBenefitResult.calculateTotalBenefitPrice();
        int totalDiscountPrice = eventBenefitResult.calculateTotalDiscountPrice();
        Badge badge = eventBenefitResult.giveBadgeByTotalBenefitPrice();

        assertThat(totalBenefitPrice).isEqualTo(31246);
        assertThat(totalDiscountPrice).isEqualTo(6246);
        assertThat(badge).isEqualTo(Badge.SANTA);
    }
}
