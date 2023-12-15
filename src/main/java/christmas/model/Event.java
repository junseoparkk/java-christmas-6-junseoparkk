package christmas.model;

import static christmas.model.EventCategory.CHRISTMAS_DAY_DISCOUNT;
import static christmas.model.EventCategory.GIVEAWAY_EVENT;
import static christmas.model.EventCategory.SPECIAL_EVENT;
import static christmas.model.EventCategory.WEEKEND_DAY_DISCOUNT;
import static christmas.model.EventCategory.WEEK_DAY_DISCOUNT;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Event {
    private final Map<EventCategory, Boolean> events = new EnumMap<EventCategory, Boolean>(EventCategory.class);
    private final Map<EventCategory, Integer> information = new EnumMap<EventCategory, Integer>(EventCategory.class);

    public Event() {
        initializeEvent();
    }

    public void apply(final int visitDay, final OrderLineItems orderLineItems) {
        if (orderLineItems.calculateTotalAmount() > 10000) {
            applyChristmasEvent(visitDay);
            applyWeekDayEvent(visitDay);
            applyWeekendDayEvent(visitDay);
            applySpecialEvent(visitDay);
            applyGiveawayEvent(orderLineItems.calculateTotalAmount());
        }
    }

    public Map<EventCategory, Integer> getInformation(final int visitDay, final OrderLineItems orderLineItems) {
        final int dessertCount = orderLineItems.calculateDessertCount();
        final int mainCount = orderLineItems.calculateMainCount();
        if (events.get(CHRISTMAS_DAY_DISCOUNT)) {
            information.put(CHRISTMAS_DAY_DISCOUNT, EventCategory.calculateChristmasDayDiscount(visitDay));
        }
        if (events.get(WEEK_DAY_DISCOUNT)) {
            information.put(WEEK_DAY_DISCOUNT, EventCategory.calculateWeekdayDiscount(dessertCount));
        }
        if (events.get(WEEKEND_DAY_DISCOUNT)) {
            information.put(WEEKEND_DAY_DISCOUNT, EventCategory.calculateWeekendDiscount(mainCount));
        }
        if (events.get(SPECIAL_EVENT)) {
            information.put(SPECIAL_EVENT, EventCategory.calculateSpecialDiscount());
        }
        if (events.get(GIVEAWAY_EVENT)) {
            information.put(GIVEAWAY_EVENT, EventCategory.calculateGiveawayEvent());
        }
        return information;
    }

    public MenuItem getGiveawayMenu(final int totalAmount) {
        if (totalAmount > 120000) {
            return MenuItem.CHAMPAGNE;
        }
        return MenuItem.NONE;
    }

    public int calculateTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (Map.Entry<EventCategory, Integer> entry : information.entrySet()) {
            totalBenefitAmount += entry.getValue();
        }
        return totalBenefitAmount;
    }

    public int calculateAfterDiscountAmount(final int totalAmount) {
        int discountAmount = calculateTotalBenefitAmount();
        if (events.get(GIVEAWAY_EVENT)) {
            discountAmount -= GIVEAWAY_EVENT.getDiscountAmount();
        }
        return totalAmount - discountAmount;
    }

    public Badge getEventBadge() {
        int totalBenefitAmount = calculateTotalBenefitAmount();
        return Badge.getBadge(totalBenefitAmount);
    }

    private void initializeEvent() {
        List<EventCategory> categories = Arrays.asList(EventCategory.values());
        for (EventCategory category : categories) {
            events.put(category, false);
        }
    }

    private void applyChristmasEvent(final int visitDay) {
        if (Calendar.isChristmasSeason(visitDay)) {
            events.replace(CHRISTMAS_DAY_DISCOUNT, true);
        }
    }

    private void applyGiveawayEvent(final int totalAmount) {
        if (totalAmount > 120000) {
            events.replace(GIVEAWAY_EVENT, true);
        }
    }

    private void applyWeekDayEvent(final int visitDay) {
        if (Calendar.isWeek(visitDay)) {
            events.replace(WEEK_DAY_DISCOUNT, true);
        }
    }

    private void applyWeekendDayEvent(final int visitDay) {
        if (Calendar.isWeekend(visitDay)) {
            events.replace(WEEKEND_DAY_DISCOUNT, true);
        }
    }

    private void applySpecialEvent(final int visitDay) {
        if (Calendar.isSpecialDay(visitDay)) {
            events.replace(SPECIAL_EVENT, true);
        }
    }
}
