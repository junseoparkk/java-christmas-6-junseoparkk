package christmas.service;

import christmas.model.event.EventBenefit;
import christmas.model.order.Order;
import christmas.repository.EventPlannerRepository;

public class EventService {
    private final EventPlannerRepository repository = EventPlannerRepository.getInstance();

    public void proceed() {
        Order order = repository.findOrder();
        EventBenefit eventBenefit = new EventBenefit(order);
        eventBenefit.applyEvent();
        repository.saveBenefit(eventBenefit);
    }
}
