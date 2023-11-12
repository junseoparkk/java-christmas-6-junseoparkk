package christmas.model.menu;

import static christmas.model.menu.MenuCategory.APPETIZER;
import static christmas.model.menu.MenuCategory.MAIN;
import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.menu.MenuCategory.BEVERAGE;

import java.util.Arrays;

public enum MenuItem {
    //APPETIZER
    MUSHROOM_SOUP(APPETIZER, "양송이수프", 6_000),
    TAPAS(APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(APPETIZER, "시저샐러드", 8_000),

    //MAIN
    T_BONE_STAKE(MAIN, "티본스테이크", 55_000),
    BARBEQUE_LIBS(MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(MAIN, "크리스마스파스타", 25_000),

    //DESSERT
    CHOCOLATE_CAKE(DESSERT, "초코케이크", 15_000),
    ICE_CREAM(DESSERT, "아이스크림", 5_000),

    //BEVERAGE
    ZERO_COKE(BEVERAGE, "제로콜라", 3_000),
    RED_WINE(BEVERAGE, "레드와인", 60_000),
    CHAMPAGNE(BEVERAGE, "샴페인", 25_000),

    NONE(MenuCategory.NONE, "없음", 0);

    private final MenuCategory category;
    private final String name;
    private final int price;

    MenuItem(MenuCategory category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public static boolean exists(final String name) {
        return Arrays.stream(values())
                .anyMatch(menuItem -> menuItem.name.equals(name));
    }

    public static MenuItem fromName(final String name) {
        return Arrays.stream(values())
                .filter(menuItem -> menuItem.getName().equals(name))
                .findFirst()
                .orElse(NONE);
    }

    public static String fromMenuItem(final MenuItem menuItem) {
        return menuItem.name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
