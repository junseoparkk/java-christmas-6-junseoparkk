package christmas.model.event.policy;

import christmas.model.event.EventCategory;
import java.util.List;

public class DiscountPolicyConfig {
    private static final List<DiscountPolicy> policies = List.of(
            christmasDiscountPolicy(),
            weekdayDiscountPolicy(),
            weekendDiscountPolicy(),
            specialDiscountPolicy(),
            giveawayEventPolicy()
    );

    public static DiscountPolicy discountPolicyFrom(final EventCategory category) {
        return policies.stream()
                .filter(policy -> policy.getEventCategory() == category)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 존재하지 않는 할인 정책입니다."));
    }

    private static DiscountPolicy christmasDiscountPolicy() {
        return new ChristmasDayDiscountPolicy();
    }

    private static DiscountPolicy weekdayDiscountPolicy() {
        return new WeekdayDiscountPolicy();
    }

    private static DiscountPolicy weekendDiscountPolicy() {
        return new WeekendDiscountPolicy();
    }

    private static DiscountPolicy specialDiscountPolicy() {
        return new SpecialDiscountPolicy();
    }

    private static DiscountPolicy giveawayEventPolicy() {
        return new GiveawayEventPolicy();
    }
}
