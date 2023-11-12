package christmas.controller;

import christmas.model.menu.MenuItem;
import christmas.model.order.Order;
import christmas.model.order.OrderLineItems;
import christmas.service.OrderService;
import christmas.utils.InputHandler;
import christmas.view.ConsoleOutputView;
import java.util.Map;
import org.mockito.internal.matchers.Or;

public class EventPlannerController {
    private final ConsoleOutputView outputView;
    private final OrderService orderService;

    public EventPlannerController(ConsoleOutputView outputView, OrderService orderService) {
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        outputView.printGreeting();
        final Order order = receiveOrderFromCustomer();
        printOrderMenu(order);
        printTotalOrderPrice(order);
    }

    private Order receiveOrderFromCustomer() {
        final int expectedVisitDate = InputHandler.receiveValidatedVisitDate();
        final OrderLineItems orderLineItems = InputHandler.receiveValidatedOrderItems();
        outputView.printEventBenefitGuide(expectedVisitDate);
        return orderService.createOrder(expectedVisitDate, orderLineItems);
    }

    private void printOrderMenu(final Order order) {
        Map<MenuItem, Integer> menu = order.getMenuWithQuantity();
        outputView.printOrderMenuMessage();
        menu.entrySet().stream()
                .map(entry -> Map.entry(MenuItem.fromMenuItem(entry.getKey()), entry.getValue()))
                .forEach(entry -> outputView.printOrderMenu(entry.getKey(), entry.getValue()));
    }

    private void printTotalOrderPrice(final Order order) {
        int totalOrderPrice = order.calculateTotalOrderPrice();
        outputView.printTotalOrderPrice(totalOrderPrice);
    }
}
