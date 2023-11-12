package christmas.model.event.policy;

import christmas.model.event.EventCategory;
import christmas.model.event.policy.DiscountPolicy;
import christmas.model.menu.MenuCategory;
import christmas.model.order.Order;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private static final int BASIC_DISCOUNT_AMOUNT = 2023;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.WEEK_END_DISCOUNT;
    }

    @Override
    public int calculateDiscountAmount(final Order order) {
        return BASIC_DISCOUNT_AMOUNT * order.countMenuQuantityByCategory(MenuCategory.MAIN);
    }
}
