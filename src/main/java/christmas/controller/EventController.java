package christmas.controller;

import christmas.model.Event;
import christmas.model.MenuItem;
import christmas.model.OrderLineItems;
import christmas.service.EventService;
import christmas.view.EventOutputView;

public class EventController {
    private final EventService eventService = new EventService();

    public void process(final int visitDay, final OrderLineItems orderLineItems) {
        if (orderLineItems.calculateTotalAmount() < 10000) {
            notApplyEvents(orderLineItems.calculateTotalAmount());
            return;
        }
        applyEvents(visitDay, orderLineItems);
    }

    private void notApplyEvents(final int totalAmount) {
        EventOutputView.printGiveawayMenu(MenuItem.CHAMPAGNE);
    }

    private void applyEvents(final int visitDay, final OrderLineItems orderLineItems) {
        final Event event = new Event();
        event.apply(visitDay, orderLineItems);
    }
}
