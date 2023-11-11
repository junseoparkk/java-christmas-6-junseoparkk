package christmas.model.event;

import christmas.model.menu.MenuCategory;
import christmas.model.order.Order;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private static final int BASIC_DISCOUNT_AMOUNT = 2023;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.WEEK_DAY_DISCOUNT;
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return BASIC_DISCOUNT_AMOUNT * order.countMenuByCategory(MenuCategory.DESSERT);
    }
}
