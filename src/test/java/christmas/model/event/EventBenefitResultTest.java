package christmas.model.event;

import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class EventBenefitResultTest {
    @Test
    void test() {
        //given
        int date = 26;
        String menu = "타파스-1,제로콜라-1";
        Order order = new Order(date, new OrderLineItems(menu));
        EventBenefit eventBenefit = new EventBenefit(order);

        //when
        eventBenefit.applyEvent();
        EventBenefitResult eventBenefitResult = new EventBenefitResult(eventBenefit, order);
        eventBenefitResult.calculateEventBenefits();
        Map<EventCategory, Integer> map = eventBenefitResult.getAllEvenResult();
        map.entrySet().stream().forEach(System.out::println);
    }
}
