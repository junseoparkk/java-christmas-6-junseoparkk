package christmas.model.badge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    @DisplayName("총혜택 금액이 20,000원 이상이면 산타를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {20000, 20001, 34567, 50000})
    void testSantaBadgeByValidAmount(int amount) {
        //when
        Badge expected = Badge.getBadgeByTotalBenefit(amount);

        //then
        assertEquals(expected, Badge.SANTA);
    }

    @DisplayName("총혜택 금액이 10,000원 이상, 20,000원 미만이면 트리를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {10000, 10001, 15000, 19999})
    void testTreeBadgeByValidAmount(int amount) {
        //when
        Badge expected = Badge.getBadgeByTotalBenefit(amount);

        //then
        assertEquals(expected, Badge.TREE);
    }

    @DisplayName("총혜택 금액이 5,000원 이상, 10,000원 미만이면 별을 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 5001, 6789, 9999})
    void testStarBadgeByValidAmount(int amount) {
        //when
        Badge expected = Badge.getBadgeByTotalBenefit(amount);

        //then
        assertEquals(expected, Badge.STAR);
    }

    @DisplayName("총혜택 금액이 0원 이상, 5,000원 미만이면 없음을 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2567, 4999})
    void testNoneBadgeByValidAmount(int amount) {
        //when
        Badge expected = Badge.getBadgeByTotalBenefit(amount);

        //then
        assertEquals(expected, Badge.NONE);
    }
}
