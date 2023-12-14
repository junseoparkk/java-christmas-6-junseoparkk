package christmas.utils;

import christmas.model.MenuItem;
import christmas.model.OrderLineItem;
import christmas.model.OrderLineItems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    private static final String COMMA = ",";
    private static final String DASH = "-";

    private Util() {
    }

    public static OrderLineItems convertToItems(final String menus) {
        final List<OrderLineItem> items = convertToItem(menus);
        return new OrderLineItems(items);
    }

    public static List<OrderLineItem> convertToItem(final String menus) {
        List<String> items = Arrays.asList(menus.split(COMMA));
        List<OrderLineItem> result = new ArrayList<>();
        for (String item : items) {
            List<String> menu = Arrays.asList(item.split(DASH));
            final String menuItem = menu.get(0);
            final int quantity = Integer.parseInt(menu.get(1));
            result.add(new OrderLineItem(menuItem, quantity));
        }
        return result;
    }
}
