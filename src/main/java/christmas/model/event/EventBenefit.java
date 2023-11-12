package christmas.model.event;

import static christmas.model.event.EventCategory.CHRISTMAS_DAY_DISCOUNT;
import static christmas.model.event.EventCategory.GIVEAWAY_EVENT;
import static christmas.model.event.EventCategory.SPECIAL_DISCOUNT;
import static christmas.model.event.EventCategory.WEEK_DAY_DISCOUNT;
import static christmas.model.event.EventCategory.WEEK_END_DISCOUNT;

import christmas.model.order.Order;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EventBenefit {
    private static final int MINIMUM_ORDER_PRICE = 10_000;
    private static final int GIVEAWAY_EVENT_STANDARD_PRICE = 120_000;
    private final Map<EventCategory, Boolean> benefits = new EnumMap<>(EventCategory.class);
    private final Order order;

    public EventBenefit(final Order order) {
        List<EventCategory> events = Arrays.asList(EventCategory.values());
        events.forEach(event -> benefits.put(event, false));
        this.order = order;
    }

    public Map<EventCategory, Boolean> applyEvent() {
        if (order.calculateTotalOrderPrice() > MINIMUM_ORDER_PRICE) {
            applyChristmasDiscountPolicy(order);
            applyWeekdayDiscountPolicy(order);
            applyWeekendDiscountPolicy(order);
            applySpecialDiscountPolicy(order);
            applyGiveawayDiscountPolicy(order);
        }
        return Collections.unmodifiableMap(benefits);
    }

    public boolean findAppliedEventFrom(final EventCategory eventCategory) {
        return benefits.get(eventCategory);
    }

    private void applyChristmasDiscountPolicy(Order order) {
        if (order.isChristmasDiscountSeason()) {
            benefits.replace(CHRISTMAS_DAY_DISCOUNT, true);
        }
    }

    private void applyWeekdayDiscountPolicy(Order order) {
        if (order.isWeekdayDiscountDate()) {
            benefits.replace(WEEK_DAY_DISCOUNT, true);
        }
    }

    private void applyWeekendDiscountPolicy(Order order) {
        if (order.isWeekendDiscountDate()) {
            benefits.replace(WEEK_END_DISCOUNT, true);
        }
    }

    private void applySpecialDiscountPolicy(Order order) {
        if (order.isSpecialDiscountDate()) {
            benefits.replace(SPECIAL_DISCOUNT, true);
        }
    }

    private void applyGiveawayDiscountPolicy(Order order) {
        if (order.calculateTotalOrderPrice() >= GIVEAWAY_EVENT_STANDARD_PRICE) {
            benefits.replace(GIVEAWAY_EVENT, true);
        }
    }
}
