package christmas.model.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int FIRST_DATE = 1;
    private static final int CHRISTMAS_DATE = 25;

    private Calendar() {
    }

    public static boolean isChristmasDiscountSeason(final int date) {
        return FIRST_DATE <= date && date <= CHRISTMAS_DATE;
    }

    public static boolean isWeekend(final int date) {
        DayOfWeek dayOfWeek = getDayOfWeekFrom(date);
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public static boolean isWeekday(final int date) {
        return !isWeekend(date);
    }

    //==이벤트 달력에 별이 있는 날인지 판단==//
    public static boolean isSpecialDiscountDay(final int date) {
        return getDayOfWeekFrom(date) == DayOfWeek.SUNDAY || isChristmas(date);
    }

    private static DayOfWeek getDayOfWeekFrom(final int date) {
        LocalDate currentDate = getCurrentDate(date);
        return currentDate.getDayOfWeek();
    }

    private static LocalDate getCurrentDate(final int date) {
        return LocalDate.of(YEAR, MONTH, date);
    }

    private static boolean isChristmas(final int date) {
        return date == CHRISTMAS_DATE;
    }
}
