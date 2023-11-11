package christmas;

import christmas.controller.EventPlannerController;
import christmas.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleOutputView outputView = new ConsoleOutputView();
        EventPlannerController eventPlannerController = new EventPlannerController(outputView);
        eventPlannerController.run();
    }
}
