package christmas.model;

import java.lang.ref.Cleaner;
import java.util.Arrays;
import java.util.List;

public enum Calendar {
    MONDAY("월요일", List.of(4, 11, 18, 25)),
    TUESDAY("화요일", List.of(5, 12, 19, 26)),
    WEDNESDAY("수요일", List.of(6, 13, 20, 27)),
    THURSDAY("목요일", List.of(7, 14, 21, 28)),
    FRIDAY("금요일", List.of(1, 8, 15, 22, 29)),
    SATURDAY("토요일", List.of(2, 9, 16, 23, 30)),
    SUNDAY("일요일", List.of(3, 10, 17, 24, 31));

    private final String dayWeek;
    private final List<Integer> days;

    Calendar(String dayWeek, List<Integer> days) {
        this.dayWeek = dayWeek;
        this.days = days;
    }

    public static Calendar from(final int day) {
        return Arrays.stream(values())
                .filter(v -> v.days.contains(day))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 날짜입니다."));
    }

    public static boolean isChristmasSeason(final int day) {
        return 1 <= day && day <= 25;
    }

    public static boolean isWeekend(final int day) {
        return from(day) == FRIDAY || from(day) == SATURDAY;
    }

    public static boolean isWeek(final int day) {
        return !isWeekend(day);
    }

    public static boolean isSpecialDay(final int day) {
        return from(day) == SUNDAY || day == 25;
    }
}
