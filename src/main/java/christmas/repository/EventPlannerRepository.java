package christmas.repository;

import christmas.model.event.EventBenefit;
import christmas.model.order.Order;

public class EventPlannerRepository {
    private static EventPlannerRepository instance = new EventPlannerRepository();
    private Order order;
    private EventBenefit benefit;

    private EventPlannerRepository() {
    }

    public static EventPlannerRepository getInstance() {
        return instance;
    }

    public void saveOrder(final Order order) {
        this.order = order;
    }

    public void saveBenefit(final EventBenefit benefit) {
        this.benefit = benefit;
    }

    public Order findOrder() {
        return order;
    }
}
