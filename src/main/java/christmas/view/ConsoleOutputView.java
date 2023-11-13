package christmas.view;

import static christmas.model.menu.MenuItem.NONE;

import christmas.model.event.EventCategory;
import christmas.model.menu.GiveawayMenu;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class ConsoleOutputView {
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private static final String EVENT_PLANNER_GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_GUIDE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    private static final String GIVEAWAY_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS_MESSAGE = "<혜택 내역>";
    private static final String MENU_WITH_QUANTITY = "%s %d개";
    private static final String BENEFIT_DETAILS = "%s: -%s원";
    private static final String WON = "%s원";
    private static final String NONE = "없음";

    public void printGreeting() {
        System.out.println(EVENT_PLANNER_GREETING_MESSAGE);
    }

    public void printEventBenefitGuide(final int date) {
        System.out.printf(EVENT_BENEFIT_GUIDE_MESSAGE, date);
        printBlankLine();
        printBlankLine();
    }

    public void printOrderMenuMessage() {
        System.out.println(ORDER_MENU_MESSAGE);
    }

    public void printOrderMenu(final String name, final int quantity) {
        System.out.printf(MENU_WITH_QUANTITY, name, quantity);
        printBlankLine();
    }

    public void printTotalOrderPrice(final int price) {
        printBlankLine();
        System.out.println(TOTAL_ORDER_PRICE_MESSAGE);
        System.out.printf(WON, numberFormat.format(price));
        printBlankLine();
    }

    public void printGiveawayMenuMessage() {
        printBlankLine();
        System.out.println(GIVEAWAY_MENU_MESSAGE);
    }

    public void printGiveawayMenu(final GiveawayMenu giveawayMenu) {
        System.out.printf(MENU_WITH_QUANTITY, giveawayMenu.getName(), giveawayMenu.quantity());
        printBlankLine();
    }

    public void printBenefitDetailsMessage() {
        printBlankLine();
        System.out.println(BENEFIT_DETAILS_MESSAGE);
    }

    public void printBenefitDetails(final Map<EventCategory, Integer> result) {
        result.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .forEach(entry -> {
                    String event = entry.getKey().getName();
                    int amount = entry.getValue();
                    System.out.printf(BENEFIT_DETAILS, event, numberFormat.format(amount));
                    printBlankLine();
                });
    }

    public void printNone() {
        System.out.println(NONE);
    }

    public static void printException(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
