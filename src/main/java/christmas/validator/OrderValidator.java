package christmas.validator;

import christmas.exception.InvalidOrderException;
import christmas.model.menu.MenuItem;

public class OrderValidator {
    private static final int MINIMUM_QUANTITY = 1;

    private OrderValidator() {
    }

    public static void validateOrderLineItem(final String name, final int quantity) {
        validateMenuExists(name);
        validateQuantity(quantity);
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
}
