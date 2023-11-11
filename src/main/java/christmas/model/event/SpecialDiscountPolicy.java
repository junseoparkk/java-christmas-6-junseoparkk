package christmas.model.event;

import christmas.model.order.Order;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.SPECIAL_DISCOUNT;
    }

    @Override
    public int calculateDiscountAmount(final Order order) {
        return BASIC_DISCOUNT_AMOUNT;
    }
}
