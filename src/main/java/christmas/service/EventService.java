package christmas.service;

import christmas.model.order.Order;

public class EventService {
    private Order order;

    public void saveOrder(final Order order) {
        this.order = order;
    }
}
