package christmas.view;

import christmas.model.Badge;
import christmas.model.EventCategory;
import christmas.model.MenuItem;
import java.util.Map;

public class EventOutputView {
    private EventOutputView() {
    }

    public static void printGiveawayMenu(final MenuItem menuItem) {
        System.out.println("<증정 메뉴>");
        System.out.println(menuItem.getMenu());
        printBlankLine();
    }

    public static void printBenefitInformation(final Map<EventCategory, Integer> information) {
        System.out.println("<혜택 내역>");
        for (Map.Entry<EventCategory, Integer> entry : information.entrySet()) {
            System.out.printf("%s: -%,d원", entry.getKey().getName(), entry.getValue());
            printBlankLine();
        }
        printBlankLine();
    }

    public static void printTotalBenefitAmount(final int totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원", totalBenefitAmount);
        printBlankLine();
        printBlankLine();
    }

    public static void printAfterDiscountAmount(final int payAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원", payAmount);
        printBlankLine();
        printBlankLine();
    }

    public static void printEventBadge(final Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getName());
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
