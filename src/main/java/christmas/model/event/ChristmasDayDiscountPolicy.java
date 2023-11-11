package christmas.model.event;

import christmas.model.order.Order;

public class ChristmasDayDiscountPolicy implements DiscountPolicy {
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int DISCOUNT_AMOUNT = 100;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.CHRISTMAS_DAY_DISCOUNT;
    }

    @Override
    public int calculateDiscountAmount(final Order order) {
        return BASIC_DISCOUNT_AMOUNT + order.calculatePreviousDate() * DISCOUNT_AMOUNT;
    }
}
