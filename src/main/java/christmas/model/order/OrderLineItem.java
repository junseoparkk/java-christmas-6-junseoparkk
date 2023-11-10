package christmas.model.order;

import christmas.validator.OrderValidator;
import org.junit.jupiter.api.Order;

public class OrderLineItem {
    private final String name;
    private final int quantity;

    public OrderLineItem(final String name, final int quantity) {
        OrderValidator.validateOrderLineItem(name, quantity);
        this.name = name;
        this.quantity = quantity;
    }
}
