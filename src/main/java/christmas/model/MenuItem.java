package christmas.model;

import static christmas.model.MenuCategory.APPETIZER;
import static christmas.model.MenuCategory.BEVERAGE;
import static christmas.model.MenuCategory.DESSERT;
import static christmas.model.MenuCategory.MAIN;

public enum MenuItem {
    //APPETIZER
    MUSHROOM_SOUP(APPETIZER, "양송이수프", 6000),
    TAPAS(APPETIZER, "타파스", 5500),
    SALAD(APPETIZER, "시저샐러드", 3000),

    //MAIN
    T_BONE_STAKE(MAIN, "티본스테이크", 55000),
    BARBEQUE(MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MAIN, "크리스마스파스타", 25000),

    //DESSERT
    CHOCOLATE_CAKE(DESSERT, "초코케이크", 15000),
    ICE_CREAM(DESSERT, "아이스크림", 5000),

    //BEVERAGE
    ZERO_COKE(BEVERAGE, "제로콜라", 3000),
    RED_WINE(BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(BEVERAGE, "샴페인", 25000);

    private final MenuCategory category;
    private final String menu;
    private final int price;

    MenuItem(MenuCategory category, String menu, int price) {
        this.category = category;
        this.menu = menu;
        this.price = price;
    }
}
