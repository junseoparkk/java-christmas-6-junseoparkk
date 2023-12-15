package christmas.view;

import christmas.model.MenuItem;

public class EventOutputView {
    private EventOutputView() {
    }

    public static void printGiveawayMenu(final MenuItem menuItem) {
        System.out.println("<증정 메뉴>");
        System.out.println(menuItem.getMenu());
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
