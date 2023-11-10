package christmas.model.order;

import christmas.model.menu.MenuCategory;
import christmas.model.menu.MenuItem;
import christmas.validator.OrderValidator;

public record OrderLineItem(String name, int quantity) {
    public OrderLineItem {
        OrderValidator.validateOrderLineItem(name, quantity);
    }

    public MenuCategory getMenuCategory() {
        return MenuItem.fromName(name).getCategory();
    }
}
