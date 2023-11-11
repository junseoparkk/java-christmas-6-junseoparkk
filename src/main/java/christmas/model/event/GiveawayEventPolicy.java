package christmas.model.event;

import christmas.model.menu.MenuItem;
import christmas.model.order.Order;

public class GiveawayEventPolicy implements DiscountPolicy {
    private static final int DISCOUNT_STANDARD_AMOUNT = 120_000;
    private static final MenuItem GIFT_ITEM = MenuItem.CHAMPAGNE;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.GIVEAWAY_EVENT;
    }

    @Override
    public int calculateDiscountAmount(Order order) {
        return GIFT_ITEM.getPrice();
    }

    public MenuItem giveItem(final int totalOrderAmount) {
        if (isOverStandardAmount(totalOrderAmount)) {
            return GIFT_ITEM;
        }
        return MenuItem.NONE;
    }

    private boolean isOverStandardAmount(int amount) {
        return DISCOUNT_STANDARD_AMOUNT <= amount;
    }
}
