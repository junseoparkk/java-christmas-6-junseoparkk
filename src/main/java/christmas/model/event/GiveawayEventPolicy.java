package christmas.model.event;

import static christmas.model.menu.MenuItem.*;

import christmas.model.menu.MenuItem;
import christmas.model.order.Order;

public class GiveawayEventPolicy implements DiscountPolicy {
    private static final int DISCOUNT_STANDARD_AMOUNT = 120_000;
    private static final MenuItem GIFT_ITEM = CHAMPAGNE;

    @Override
    public EventCategory getEventCategory() {
        return EventCategory.GIVEAWAY_EVENT;
    }

    @Override
    public int calculateDiscountAmount(final Order order) {
        int totalOrderAmount = order.calculateTotalOrderPrice();
        if (isOverStandardAmount(totalOrderAmount)) {
            return GIFT_ITEM.getPrice();
        }
        return NONE.getPrice();
    }

    public MenuItem giveItem(final Order order) {
        int totalOrderAmount = order.calculateTotalOrderPrice();
        if (isOverStandardAmount(totalOrderAmount)) {
            return GIFT_ITEM;
        }
        return NONE;
    }

    private boolean isOverStandardAmount(int amount) {
        return DISCOUNT_STANDARD_AMOUNT <= amount;
    }
}
