package christmas.model.event;

public enum EventCategory {
    //DISCOUNT
    CHRISTMAS_DAY_DISCOUNT("크리스마스 디데이 할인"),
    WEEK_DAY_DISCOUNT("평일 할인"),
    WEEK_END_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인"),

    //EVENT
    GIVEAWAY_EVENT("증정 이벤트");

    private final String name;

    EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
