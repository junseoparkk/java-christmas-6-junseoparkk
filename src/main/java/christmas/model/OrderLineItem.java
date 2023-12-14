package christmas.model;

public class OrderLineItem {
    private final MenuItem menu;
    private final int quantity;

    public OrderLineItem(final String menu, final int quantity) {
        validateMenu(menu);
        validateQuantity(quantity);
        this.menu = MenuItem.from(menu);
        this.quantity = quantity;
    }

    private void validateMenu(final String menu) {
        MenuItem menuItem = MenuItem.from(menu);
        if (menuItem == MenuItem.NONE) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
        }
    }

    private void validateQuantity(final int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최소 1개 이상 주문할 수 있습니다.");
        }
    }
}
