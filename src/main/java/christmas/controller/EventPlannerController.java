package christmas.controller;

import christmas.ApplicationConfig;
import christmas.view.ConsoleOutputView;

public class EventPlannerController implements Controller {
    private final OrderController orderController;
    private final EventController eventController;
    private final ConsoleOutputView outputView;

    public EventPlannerController(ApplicationConfig applicationConfig) {
        orderController = applicationConfig.orderController();
        eventController = applicationConfig.eventController();
        outputView = applicationConfig.consoleOutputView();
    }

    @Override
    public void run() {
        printGreeting();
        orderController.run();
        eventController.run();
    }

    private void printGreeting() {
        outputView.printGreeting();
    }
}
