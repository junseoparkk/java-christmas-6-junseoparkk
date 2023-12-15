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

    public int calculateChristmasDayDiscount(final int day) {
        if (this == CHRISTMAS_DAY_DISCOUNT) {
            return discountAmount + (day - 1) * 100;
        }
        return 0;
    }

    public int calculateWeekdayDiscount(final int dessertCount) {
        if (this == WEEK_DAY_DISCOUNT) {
            return dessertCount * discountAmount;
        }
        return 0;
    }

    public int calculateWeekendDiscount(final int mainCount) {
        if (this == WEEKEND_DAY_DISCOUNT) {
            return mainCount * discountAmount;
        }
        return 0;
    }

    public int calculateSpecialDiscount() {
        if (this == SPECIAL_EVENT) {
            return discountAmount;
        }
        return 0;
    }

    public int calculateGiveawayEvent() {
        if (this == GIVEAWAY_EVENT) {
            return discountAmount;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
