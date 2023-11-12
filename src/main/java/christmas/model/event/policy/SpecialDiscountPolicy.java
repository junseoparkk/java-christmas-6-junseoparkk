package christmas.model.event.policy;

import christmas.model.event.EventCategory;
import christmas.model.event.policy.DiscountPolicy;
import christmas.model.order.Order;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int NONE_DISCOUNT_AMOUNT = 0;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.SPECIAL_DISCOUNT;
    }

    @Override
    public int calculateDiscountAmount(final Order order) {
        if (order.isSpecialDiscountDate()) {
            return BASIC_DISCOUNT_AMOUNT;
        }
        return NONE_DISCOUNT_AMOUNT;
    }
}
