package christmas;

import christmas.controller.EventPlannerController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        EventPlannerController eventPlannerController = new EventPlannerController(applicationConfig);
        eventPlannerController.run();
    }
}
