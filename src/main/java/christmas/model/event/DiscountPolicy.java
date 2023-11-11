package christmas.model.event;

import christmas.model.order.Order;

public interface DiscountPolicy {
    EventCategory getEventCategory();
    int calculateDiscountAmount(Order order);
}
