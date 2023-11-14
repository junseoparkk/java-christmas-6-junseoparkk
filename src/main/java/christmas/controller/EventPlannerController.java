package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
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
        closeConsole();
    }

    private void printGreeting() {
        outputView.printGreeting();
    }

    private void closeConsole() {
        Console.close();
    }
}
