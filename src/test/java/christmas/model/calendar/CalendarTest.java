package christmas.model.calendar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalendarTest {
    @DisplayName("2023년 12월 1일 ~ 2023년 12월 25일 사이의 날짜는 크리스마스 할인 기간이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 15, 23, 25})
    void testChristmasDiscountSeasonByValidDate(int date) {
        //when, then
        assertThat(Calendar.isChristmasDiscountSeason(date)).isTrue();
    }

    @DisplayName("2023년 12월 1일 ~ 2023년 12월 25일 사이의 날짜가 아니라면 크리스마스 할인 기간이 아니어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {26, 29, 31})
    void testNotChristmasDiscountSeasonByDate(int date) {
        //when, then
        assertThat(Calendar.isChristmasDiscountSeason(date)).isFalse();
    }

    @DisplayName("금요일 또는 토요일에 해당하는 날짜는 주말이어야 한다.")
    @Test
    void testWeekendByValidDate() {
        //given, when
        List<Integer> weekendDates = IntStream.rangeClosed(1, 31)
                .filter(Calendar::isWeekend)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> expected = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);

        //then
        assertThat(weekendDates).isEqualTo(expected);
    }

    @DisplayName("일요일 ~ 월요일 사이에 해당하는 날짜는 평일이어야 한다.")
    @Test
    void testWeekdayByValidDate() {
        //given, when
        List<Integer> weekdayDates = IntStream.rangeClosed(1, 31)
                .filter(Calendar::isWeekday)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThat(weekdayDates.size()).isEqualTo(21);
    }

    @DisplayName("이벤트 달력에 별이 있는 날은 특별 할인 날이어야 한다.")
    @Test
    void testSpecialDayByValidDate() {
        //given, when
        List<Integer> specialDayDates = IntStream.rangeClosed(1, 31)
                .filter(Calendar::isSpecialDiscountDay)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> expected = List.of(3, 10, 17, 24, 25, 31);

        //then
        assertThat(specialDayDates).isEqualTo(expected);
    }

    @DisplayName("2023년 12월 25일은 크리스마스 할인 기간, 평일, 특별 할인 날이어야 한다.")
    @Test
    void testChristmasDay() {
        //given
        int christmasDate = 25;

        assertThat(Calendar.isChristmasDiscountSeason(christmasDate)).isTrue();
        assertThat(Calendar.isWeekday(christmasDate)).isTrue();
        assertThat(Calendar.isSpecialDiscountDay(christmasDate)).isTrue();
    }
}
