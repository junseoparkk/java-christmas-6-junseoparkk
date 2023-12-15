package christmas.model;

import static christmas.model.MenuCategory.BEVERAGE;
import static christmas.model.MenuCategory.DESSERT;
import static christmas.model.MenuCategory.MAIN;

import java.util.Objects;

public class OrderLineItem {
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final MenuItem menu;
    private final int quantity;

    public OrderLineItem(final String menu, final int quantity) {
        validateMenu(menu);
        validateQuantity(quantity);
        this.menu = MenuItem.from(menu);
        this.quantity = quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof OrderLineItem) {
            return menu == ((OrderLineItem) o).menu;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menu);
    }

    @Override
    public String toString() {
        return menu.getMenu() + " " + quantity + "개";
    }

    public boolean isBeverage() {
        return menu.getCategory() == BEVERAGE;
    }

    public boolean isDessert() {
        return menu.getCategory() == DESSERT;
    }

    public boolean isMain() {
        return menu.getCategory() == MAIN;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return menu.getPrice() * quantity;
    }

    private void validateMenu(final String menu) {
        MenuItem menuItem = MenuItem.from(menu);
        if (menuItem == MenuItem.NONE) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateQuantity(final int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
