package christmas.service;

import christmas.model.badge.Badge;
import christmas.model.event.EventBenefit;
import christmas.model.event.EventBenefitResult;
import christmas.model.event.EventCategory;
import christmas.model.menu.GiveawayMenu;
import christmas.model.order.Order;
import christmas.repository.EventPlannerRepository;
import java.util.Map;

public class EventService {
    private static final int MINIMUM_EVENT_PRICE = 10_000;
    private final EventPlannerRepository repository = EventPlannerRepository.getInstance();

    public void proceed() {
        Order order = repository.findOrder();

        EventBenefit eventBenefit = new EventBenefit(order);
        eventBenefit.applyEvent();

        EventBenefitResult eventBenefitResult = new EventBenefitResult(eventBenefit, order);
        eventBenefitResult.calculateEventBenefits();

        repository.saveEventBenefit(eventBenefit);
        repository.saveEventBenefitResult(eventBenefitResult);
    }

    public GiveawayMenu getGiveawayMenu() {
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        return eventBenefitResult.getGiveawayMenuInformation();
    }

    public Map<EventCategory, Integer> getAllEvents() {
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        return eventBenefitResult.getAllEventResult();
    }

    public boolean isNotAppliedEvent() {
        return isLessMinimumEventPrice() || isNothingAppliedEvent();
    }

    public int calculateTotalBenefitAmount() {
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        return eventBenefitResult.calculateTotalBenefitPrice();
    }

    public int calculatePayAmount() {
        Order order = repository.findOrder();
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        return order.calculateTotalOrderPrice() - eventBenefitResult.calculateTotalDiscountPrice();
    }

    public Badge getEventBadge() {
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        int totalBenefitAmount = eventBenefitResult.calculateTotalBenefitPrice();
        return Badge.getBadgeByTotalBenefit(totalBenefitAmount);
    }

    private boolean isLessMinimumEventPrice() {
        Order order = repository.findOrder();
        return order.calculateTotalOrderPrice() < MINIMUM_EVENT_PRICE;
    }

    private boolean isNothingAppliedEvent() {
        EventBenefitResult eventBenefitResult = repository.findEventBenefitResult();
        return eventBenefitResult.isNothingAppliedEvent();
    }
}
