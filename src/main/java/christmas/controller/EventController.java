package christmas.controller;

import christmas.model.Event;
import christmas.model.EventCategory;
import christmas.model.OrderLineItems;
import christmas.view.EventOutputView;
import java.util.Map;

public class EventController {
    public void process(final int visitDay, final OrderLineItems orderLineItems) {
        applyEvents(visitDay, orderLineItems);
    }

    private void applyEvents(final int visitDay, final OrderLineItems orderLineItems) {
        final Event event = new Event();
        event.apply(visitDay, orderLineItems);
        final Map<EventCategory, Integer> eventInformation = event.getInformation(visitDay, orderLineItems);
        EventOutputView.printGiveawayMenu(event.getGiveawayMenu(orderLineItems.calculateTotalAmount()));
        EventOutputView.printBenefitInformation(eventInformation);
        EventOutputView.printTotalBenefitAmount(event.calculateTotalBenefitAmount());
        EventOutputView.printAfterDiscountAmount(event.calculateAfterDiscountAmount(orderLineItems.calculateTotalAmount()));
        EventOutputView.printEventBadge(event.getEventBadge());
    }
}