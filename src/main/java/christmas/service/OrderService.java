package christmas.service;

import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;

public class OrderService {
    public Order createOrder(final int date, final OrderLineItems items) {
        return new Order(date, items);
    }
}
