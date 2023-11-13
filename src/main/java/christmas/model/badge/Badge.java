package christmas.model.badge;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int standardAmount;

    Badge(String name, int standardAmount) {
        this.name = name;
        this.standardAmount = standardAmount;
    }

    public static Badge getBadgeByTotalBenefit(final int amount) {
        return Arrays.stream(values())
                .filter(badge -> badge.standardAmount <= amount)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
