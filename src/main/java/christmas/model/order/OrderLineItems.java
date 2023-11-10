package christmas.model.order;

import christmas.model.menu.MenuItem;
import christmas.validator.OrderValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Order;

public class OrderLineItems {
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private final List<OrderLineItem> items;

    public OrderLineItems(final String requestOrderLineItems) {
        List<String> eachOrders = mapToListByDelimiter(requestOrderLineItems);
        List<OrderLineItem> items = processOrder(eachOrders);
        this.items = items;
    }

    private List<String> mapToListByDelimiter(String orderRequest) {
        return Arrays.asList(orderRequest.split(COMMA));
    }

    private List<OrderLineItem> processOrder(List<String> eachOrders) {
        return eachOrders.stream()
                .map(order -> order.split(DASH))
                .map(parts -> new OrderLineItem(parts[0], Integer.parseInt(parts[1])))
                .collect(Collectors.toList());
    }
}
