package christmas.repository;

import christmas.model.event.EventBenefit;
import christmas.model.event.EventBenefitResult;
import christmas.model.order.Order;

public class EventPlannerRepository {
    private static EventPlannerRepository instance = new EventPlannerRepository();
    private Order order;
    private EventBenefit eventBenefit;
    private EventBenefitResult eventBenefitResult;

    private EventPlannerRepository() {
    }

    public static EventPlannerRepository getInstance() {
        return instance;
    }

    public void saveOrder(final Order order) {
        this.order = order;
    }

    public void saveEventBenefit(final EventBenefit eventBenefit) {
        this.eventBenefit = eventBenefit;
    }

    public void saveEventBenefitResult(final EventBenefitResult eventBenefitResult) {
        this.eventBenefitResult = eventBenefitResult;
    }

    public Order findOrder() {
        return order;
    }

    public EventBenefit findEventBenefit() {
        return eventBenefit;
    }

    public EventBenefitResult findEventBenefitResult() {
        return eventBenefitResult;
    }
}
