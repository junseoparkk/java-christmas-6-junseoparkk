package christmas;

import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.ConsoleOutputView;

public class ApplicationConfig {
    public OrderController orderController() {
        return new OrderController(this);
    }

    public EventController eventController() {
        return new EventController(this);
    }

    public ConsoleOutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public OrderService orderService() {
        return new OrderService();
    }

    public EventService eventService() {
        return new EventService();
    }
}
