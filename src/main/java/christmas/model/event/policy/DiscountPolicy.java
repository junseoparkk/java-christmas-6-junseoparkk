package christmas.model.event.policy;

import christmas.model.event.EventCategory;
import christmas.model.order.Order;

public interface DiscountPolicy {
    EventCategory getEventCategory();
    int calculateDiscountAmount(Order order);
}
