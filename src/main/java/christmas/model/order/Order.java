package christmas.model.order;

public class Order {
    private final int date;
    private final OrderLineItems menu;

    public Order(int date, OrderLineItems menu) {
        this.date = date;
        this.menu = menu;
    }
}
