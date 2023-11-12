package christmas.service;

import christmas.model.menu.MenuItem;
import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import christmas.repository.EventPlannerRepository;
import java.util.Map;

public class OrderService {
    private final EventPlannerRepository repository = EventPlannerRepository.getInstance();

    public Order createOrder(final int date, final OrderLineItems items) {
        repository.saveOrder(new Order(date, items));
        return repository.findOrder();
    }

    public Map<MenuItem, Integer> getMenuWithQuantity() {
        Order order = repository.findOrder();
        return order.getMenuWithQuantity();
    }

    public int calculateTotalOrderPrice() {
        Order order = repository.findOrder();
        return order.calculateTotalOrderPrice();
    }
}
