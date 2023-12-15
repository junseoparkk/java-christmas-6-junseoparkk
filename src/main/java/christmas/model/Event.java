package christmas.model;

import static christmas.model.EventCategory.CHRISTMAS_DAY_DISCOUNT;
import static christmas.model.EventCategory.GIVEAWAY_EVENT;

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
}
