package christmas.controller;

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
    }
}
