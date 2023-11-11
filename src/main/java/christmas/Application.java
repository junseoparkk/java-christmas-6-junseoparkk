package christmas;

import christmas.controller.EventPlannerController;
import christmas.service.OrderService;
import christmas.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleOutputView outputView = new ConsoleOutputView();
        OrderService orderService = new OrderService();
        EventPlannerController eventPlannerController = new EventPlannerController(outputView, orderService);
        eventPlannerController.run();
    }
}
