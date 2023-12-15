package christmas.view;

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
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
