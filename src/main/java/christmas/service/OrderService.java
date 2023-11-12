package christmas.service;

import christmas.model.menu.MenuItem;
import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import java.util.Map;

public class OrderService {
    private Order order;

    public Order createOrder(final int date, final OrderLineItems items) {
        order = saveOrder(date, items);
        return order;
    }

    public Map<MenuItem, Integer> getMenuWithQuantity() {
        return order.getMenuWithQuantity();
    }

    public int calculateTotalOrderPrice() {
        return order.calculateTotalOrderPrice();
    }

    private Order saveOrder(int date, OrderLineItems items) {
        return new Order(date, items);
    }
}
