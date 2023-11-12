package christmas.model.event;

import static christmas.model.event.EventCategory.GIVEAWAY_EVENT;
import static christmas.model.menu.MenuItem.CHAMPAGNE;

import christmas.model.badge.Badge;
import christmas.model.event.policy.DiscountPolicy;
import christmas.model.event.policy.DiscountPolicyConfig;
import christmas.model.menu.MenuItem;
import christmas.model.order.Order;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EventBenefitResult {
    private static final MenuItem GIFT_ITEM = CHAMPAGNE;
    private final Map<EventCategory, Integer> result = new EnumMap<>(EventCategory.class);
    private final EventBenefit eventBenefit;
    private final Order order;

    public EventBenefitResult(final EventBenefit eventBenefit, final Order order) {
        initializeResult();
        this.eventBenefit = eventBenefit;
        this.order = order;
    }

    public void calculateEventBenefits() {
        Map<EventCategory, Boolean> benefits = eventBenefit.getAllBenefits();
        for (Entry<EventCategory, Boolean> entry : benefits.entrySet()) {
            if (entry.getValue()) {
                DiscountPolicy discountPolicy = DiscountPolicyConfig.discountPolicyFrom(entry.getKey());
                int discountAmount = discountPolicy.calculateDiscountAmount(order);
                result.replace(entry.getKey(), discountAmount);
            }
        }
    }

    public Map<EventCategory, Integer> getAllEvenResult() {
        return Collections.unmodifiableMap(new EnumMap<>(result));
    }

    public int calculateTotalBenefitPrice() {
        return result.entrySet().stream()
                .map(Map.Entry::getValue)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalDiscountPrice() {
        int totalBenefitPrice = calculateTotalBenefitPrice();
        if (result.get(GIVEAWAY_EVENT) != 0) {
            totalBenefitPrice -= GIFT_ITEM.getPrice();
        }
        return totalBenefitPrice;
    }

    public Badge giveBadgeByTotalBenefitPrice() {
        return Badge.getBadgeByTotalBenefit(calculateTotalBenefitPrice());
    }

    private void initializeResult() {
        List<EventCategory> events = Arrays.asList(EventCategory.values());
        events.forEach(event -> result.put(event, 0));
    }
}
