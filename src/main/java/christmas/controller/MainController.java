package christmas.controller;

import christmas.model.OrderLineItems;
import christmas.utils.InputHandler;
import christmas.view.OutputView;

public class MainController {
    public void process() {
        OutputView.printStartService();
        final int visitDay = InputHandler.receiveVisitDay();
        final OrderLineItems orderLineItems = InputHandler.receiveOrderLineItems();
        OutputView.printInformationMessage(visitDay);
    }
}
