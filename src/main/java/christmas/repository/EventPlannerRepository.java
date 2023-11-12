package christmas.repository;

import christmas.model.order.Order;

public class EventPlannerRepository {
    private static EventPlannerRepository instance = new EventPlannerRepository();
    private Order order;

    private EventPlannerRepository() {
    }

    public static EventPlannerRepository getInstance() {
        return instance;
    }

    public void saveOrder(final Order order) {
        this.order = order;
    }

    public Order findOrder() {
        return order;
    }
}
