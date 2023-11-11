package christmas.controller;

import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import christmas.service.OrderService;
import christmas.utils.InputHandler;
import christmas.view.ConsoleOutputView;

public class EventPlannerController {
    private final ConsoleOutputView outputView;
    private final OrderService orderService;

    public EventPlannerController(ConsoleOutputView outputView, OrderService orderService) {
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        outputView.printGreeting();
        final Order order = receiveOrderFromCustomer();
    }

    private Order receiveOrderFromCustomer() {
        final int expectedVisitDate = InputHandler.receiveValidatedVisitDate();
        final OrderLineItems orderLineItems = InputHandler.receiveValidatedOrderItems();
        outputView.printEventBenefitGuide(expectedVisitDate);
        return orderService.createOrder(expectedVisitDate, orderLineItems);
    }
}
