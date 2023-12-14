package christmas.model;

public enum MenuCategory {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료"),
    NONE("없음");

    private final String category;

    MenuCategory(String category) {
        this.category = category;
    }
}
