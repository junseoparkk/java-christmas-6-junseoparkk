package christmas.model.order;

import christmas.model.menu.MenuCategory;
import christmas.model.menu.MenuItem;
import christmas.validator.OrderValidator;

public class OrderLineItem {
    private final String name;
    private final int quantity;

    public OrderLineItem(final String name, final int quantity) {
        OrderValidator.validateOrderLineItem(name, quantity);
        this.name = name;
        this.quantity = quantity;
    }

    public MenuCategory getMenuCategory() {
        return MenuItem.fromName(name).getCategory();
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
