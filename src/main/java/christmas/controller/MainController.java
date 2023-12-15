package christmas.controller;

import christmas.model.OrderLineItems;
import christmas.utils.InputHandler;
import christmas.view.OutputView;

public class MainController {
    private final EventController eventController;

    public MainController(final EventController eventController) {
        this.eventController = eventController;
    }

    public void process() {
        OutputView.printStartService();
        final int visitDay = InputHandler.receiveVisitDay();
        final OrderLineItems orderLineItems = InputHandler.receiveOrderLineItems();
        OutputView.printInformationMessage(visitDay);
        OutputView.printAllMenus(orderLineItems);
        OutputView.printTotalAmount(orderLineItems.calculateTotalAmount());
        eventController.process(visitDay, orderLineItems);
    }
}
