package christmas.model;

import java.util.function.Predicate;

public enum Badge {
    SANTA("산타", (totalBenefit) -> totalBenefit >= 20000),
    TREE("트리", (totalBenefit) -> 10000 <= totalBenefit && totalBenefit < 20000),
    STAR("별", (totalBenefit) -> 5000 <= totalBenefit && totalBenefit < 10000),
    NONE("없음", (totalBenefit) -> 0 <= totalBenefit && totalBenefit < 5000);

    private final String name;
    private final Predicate<Integer> totalBenefit;

    Badge(String name, Predicate<Integer> totalBenefit) {
        this.name = name;
        this.totalBenefit = totalBenefit;
    }
}