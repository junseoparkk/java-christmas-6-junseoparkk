package christmas.model;

public enum EventCategory {
    CHRISTMAS_DAY_DISCOUNT("크리스마스 디데이 할인", 1000),
    WEEK_DAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DAY_DISCOUNT("주말 할인", 2023),
    SPECIAL_EVENT("특별 할인", 1000),
    GIVEAWAY_EVENT("증정 이벤트", 25000),
    NONE("없음", 0);

    private final String name;
    private final int discountAmount;

    EventCategory(String name, int discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public static int calculateChristmasDayDiscount(final int day) {
        return CHRISTMAS_DAY_DISCOUNT.discountAmount + (day - 1) * 100;
    }

    public static int calculateWeekdayDiscount(final int dessertCount) {
        return WEEKEND_DAY_DISCOUNT.discountAmount * dessertCount;
    }

    public static int calculateWeekendDiscount(final int mainCount) {
        return WEEKEND_DAY_DISCOUNT.discountAmount * mainCount;
    }

    public static int calculateSpecialDiscount() {
        return SPECIAL_EVENT.discountAmount;
    }

    public static int calculateGiveawayEvent() {
        return GIVEAWAY_EVENT.discountAmount;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}