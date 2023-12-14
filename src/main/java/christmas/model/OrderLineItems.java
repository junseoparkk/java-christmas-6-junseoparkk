package christmas.model;

import java.util.List;

public class OrderLineItems {
    private final List<OrderLineItem> items;

    public OrderLineItems(final List<OrderLineItem> items) {
        this.items = items;
    }
}
