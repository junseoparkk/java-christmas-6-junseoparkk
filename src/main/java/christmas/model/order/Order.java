package christmas.model.order;

import christmas.model.calendar.Calendar;
import christmas.model.menu.MenuCategory;
import christmas.model.menu.MenuItem;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Order {
    private final int date;
    private final OrderLineItems menus;

    public Order(int date, OrderLineItems menus) {
        this.date = date;
        this.menus = menus;
    }

    public int calculatePreviousDate() {
        return date - 1;
    }

    public int countMenuQuantityByCategory(final MenuCategory menuCategory) {
        return IntStream.range(0, menus.size())
                .mapToObj(menus::findOrderLineItemByIndex)
                .filter(menu -> menu.getMenuCategory() == menuCategory)
                .mapToInt(OrderLineItem::quantity)
                .sum();
    }

    public boolean isChristmasDiscountSeason() {
        return Calendar.isChristmasDiscountSeason(date);
    }

    public boolean isWeekdayDiscountDate() {
        return Calendar.isWeekday(date);
    }

    public boolean isWeekendDiscountDate() {
        return Calendar.isWeekend(date);
    }

    public boolean isSpecialDiscountDate() {
        return Calendar.isSpecialDiscountDay(date);
    }

    public int calculateTotalOrderPrice() {
        return IntStream.range(0, menus.size())
                .mapToObj(menus::findOrderLineItemByIndex)
                .mapToInt(item -> {
                    MenuItem menuItem = MenuItem.fromName(item.name());
                    int menuQuantity = item.quantity();
                    return menuItem.getPrice() * menuQuantity;
                })
                .sum();
    }

    public Map<MenuItem, Integer> getMenuWithQuantity() {
        return IntStream.range(0, menus.size())
                .mapToObj(menus::findOrderLineItemByIndex)
                .collect(Collectors.toMap(
                        item -> MenuItem.fromName(item.name()),
                        OrderLineItem::quantity,
                        Integer::sum,
                        () -> new EnumMap<>(MenuItem.class)
                ));
    }
}
