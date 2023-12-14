package christmas.model;

import java.util.List;
import java.util.stream.Collectors;

public class OrderLineItems {
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
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 존재합니다.");
        }
    }

    private void validateOnlyBeverage(final List<OrderLineItem> items) {
        for (OrderLineItem item : items) {
            if (!item.isBeverage()) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
    }

    private void validateTotalOrderQuantity(final List<OrderLineItem> items) {
        int totalQuantity = 0;
        for (OrderLineItem item : items) {
            totalQuantity += item.getQuantity();
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 최대 20개까지 주문할 수 있습니다..");
        }
    }
}
