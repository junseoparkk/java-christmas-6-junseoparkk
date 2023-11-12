package christmas.controller;

import christmas.model.menu.MenuItem;
import christmas.model.order.OrderLineItems;
import christmas.service.OrderService;
import christmas.utils.InputHandler;
import christmas.view.ConsoleOutputView;
import java.util.Map;

public class EventPlannerController {
    private final ConsoleOutputView outputView;
    private final OrderService orderService;

    public EventPlannerController(ConsoleOutputView outputView, OrderService orderService) {
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        outputView.printGreeting();
        receiveOrderFromCustomer();
        printOrderMenu();
        printTotalOrderPrice();
    }

    private void receiveOrderFromCustomer() {
        int expectedVisitDate = InputHandler.receiveValidatedVisitDate();
        OrderLineItems orderLineItems = InputHandler.receiveValidatedOrderItems();
        outputView.printEventBenefitGuide(expectedVisitDate);
        orderService.createOrder(expectedVisitDate, orderLineItems);
    }

    private void printOrderMenu() {
        Map<MenuItem, Integer> menu = orderService.getMenuWithQuantity();
        outputView.printOrderMenuMessage();
        menu.entrySet().stream()
                .map(entry -> Map.entry(MenuItem.fromMenuItem(entry.getKey()), entry.getValue()))
                .forEach(entry -> outputView.printOrderMenu(entry.getKey(), entry.getValue()));
    }

    private void printTotalOrderPrice() {
        int totalOrderPrice = orderService.calculateTotalOrderPrice();
        outputView.printTotalOrderPrice(totalOrderPrice);
    }
}
