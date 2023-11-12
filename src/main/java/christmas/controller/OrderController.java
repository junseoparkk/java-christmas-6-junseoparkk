package christmas.controller;

import christmas.ApplicationConfig;
import christmas.model.menu.MenuItem;
import christmas.model.order.OrderLineItems;
import christmas.service.OrderService;
import christmas.utils.InputHandler;
import christmas.view.ConsoleOutputView;
import java.util.Map;

public class OrderController implements Controller {
    private final ConsoleOutputView outputView;
    private final OrderService orderService;

    public OrderController(final ApplicationConfig applicationConfig) {
        outputView = applicationConfig.consoleOutputView();
        orderService = applicationConfig.orderService();
    }

    @Override
    public void run() {
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
