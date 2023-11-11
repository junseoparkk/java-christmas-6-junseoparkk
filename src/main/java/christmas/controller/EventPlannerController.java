package christmas.controller;

import christmas.model.order.OrderLineItems;
import christmas.utils.InputHandler;
import christmas.view.ConsoleOutputView;

public class EventPlannerController {
    private final ConsoleOutputView outputView;

    public EventPlannerController(ConsoleOutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGreeting();
        final int expectedVisitDate = InputHandler.receiveValidatedVisitDate();
        final OrderLineItems orderLineItems = InputHandler.receiveValidatedOrderItems();
        outputView.printEventBenefitGuide(expectedVisitDate);
    }
}
