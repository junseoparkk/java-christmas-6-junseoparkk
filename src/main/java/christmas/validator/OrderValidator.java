package christmas.validator;

import christmas.exception.InvalidOrderException;
import christmas.model.menu.MenuCategory;
import christmas.model.menu.MenuItem;
import christmas.model.order.OrderLineItem;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderValidator {
    private static final int MINIMUM_QUANTITY = 1;
    private static final int MAXIMUM_QUANTITY = 20;

    private OrderValidator() {
    }

    public static void validateOrderLineItem(final String name, final int quantity) {
        validateMenuExists(name);
        validateQuantity(quantity);
    }

    public static void validateOrderLineItems(final List<OrderLineItem> items) {
        validateOrderHasOnlyBeverage(items);
        validateDuplicatedItem(items);
        validateOrderItemsSize(items);
    }

    private static void validateMenuExists(String name) {
        if (isNotExistMenu(name)) {
            throw new InvalidOrderException();
        }
    }

    private static void validateQuantity(int quantity) {
        if (quantity < MINIMUM_QUANTITY) {
            throw new InvalidOrderException();
        }
    }

    private static boolean isNotExistMenu(String name) {
        return !MenuItem.exists(name);
    }

    private static void validateOrderHasOnlyBeverage(List<OrderLineItem> items) {
        Map<MenuCategory, Long> categoryCounts = items.stream()
                .collect(Collectors.groupingBy(OrderLineItem::getMenuCategory, Collectors.counting()));
        if (isContainOnlyBeverage(categoryCounts)) {
            throw new InvalidOrderException();
        }
    }

    private static boolean isContainOnlyBeverage(Map<MenuCategory, Long> categoryCounts) {
        return categoryCounts.size() == 1 && categoryCounts.containsKey(MenuCategory.BEVERAGE);
    }

    private static void validateDuplicatedItem(List<OrderLineItem> items) {
        List<String> target = items.stream()
                .map(OrderLineItem::getName)
                .distinct()
                .collect(Collectors.toList());
        if (target.size() != items.size()) {
            throw new InvalidOrderException();
        }
    }

    private static void validateOrderItemsSize(List<OrderLineItem> items) {
        int totalCounts = items.stream()
                .mapToInt(OrderLineItem::getQuantity)
                .sum();
        if (MAXIMUM_QUANTITY < totalCounts) {
            throw new InvalidOrderException();
        }
    }
}
