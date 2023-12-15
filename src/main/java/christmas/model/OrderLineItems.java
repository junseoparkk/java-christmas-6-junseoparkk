package christmas.model;

import java.util.List;
import java.util.stream.Collectors;

public class OrderLineItems {
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final List<OrderLineItem> items;

    public OrderLineItems(final List<OrderLineItem> items) {
        validateMenus(items);
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public OrderLineItem findOrderLineItemByIndex(final int index) {
        return items.get(index);
    }

    public int calculateTotalAmount() {
        int amount = 0;
        for (OrderLineItem item : items) {
            amount += item.getAmount();
        }
        return amount;
    }

    public int calculateDessertCount() {
        int count = 0;
        for (OrderLineItem item : items) {
            if (item.isDessert()) {
                count += item.getQuantity();
            }
        }
        return count;
    }

    public int calculateMainCount() {
        int count = 0;
        for (OrderLineItem item : items) {
            if (item.isMain()) {
                count += item.getQuantity();
            }
        }
        return count;
    }

    private void validateMenus(final List<OrderLineItem> items) {
        validateDuplicatedMenu(items);
        validateOnlyBeverage(items);
        validateTotalOrderQuantity(items);
    }

    private void validateDuplicatedMenu(final List<OrderLineItem> items) {
        final List<OrderLineItem> target = items.stream()
                .distinct()
                .collect(Collectors.toList());
        if (target.size() != items.size()) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private void validateOnlyBeverage(final List<OrderLineItem> items) {
        for (OrderLineItem item : items) {
            if (!item.isBeverage()) {
                return;
            }
        }
        throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
    }

    private void validateTotalOrderQuantity(final List<OrderLineItem> items) {
        int totalQuantity = 0;
        for (OrderLineItem item : items) {
            totalQuantity += item.getQuantity();
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }
}
