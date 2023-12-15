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

    public Event() {
        initializeEvent();
    }

    public void apply(final int visitDay, final OrderLineItems orderLineItems) {
        applyChristmasEvent(visitDay);
        applyWeekDayEvent(visitDay);
        applyWeekendDayEvent(visitDay);
        applySpecialEvent(visitDay);
        applyGiveawayEvent(orderLineItems.calculateTotalAmount());
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
