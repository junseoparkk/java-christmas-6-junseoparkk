package christmas.view;

import christmas.model.badge.Badge;
import christmas.model.menu.GiveawayMenu;
import java.text.DecimalFormat;

public class ConsoleOutputView {
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private static final String EVENT_PLANNER_GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_GUIDE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    private static final String GIVEAWAY_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String EXPECTED_PAY_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String MENU_WITH_QUANTITY = "%s %d개";
    private static final String MINUS_WON = "-%s원";
    private static final String WON = "%s원";
    private static final String BENEFIT_DETAILS = "%s: " + MINUS_WON;
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

    public void printBenefitDetails(final String event, final int amount) {
        System.out.printf(BENEFIT_DETAILS, event, numberFormat.format(amount));
        printBlankLine();
    }

    public void printTotalBenefitAmountMessage() {
        printBlankLine();
        System.out.println(TOTAL_BENEFIT_AMOUNT_MESSAGE);
    }

    public void printTotalBenefitAmount(final int totalBenefitAmount) {
        System.out.printf(MINUS_WON, numberFormat.format(totalBenefitAmount));
        printBlankLine();
    }

    public void printExpectedPayAmount(final int payAmount) {
        printBlankLine();
        System.out.println(EXPECTED_PAY_AMOUNT_MESSAGE);
        System.out.printf(WON, numberFormat.format(payAmount));
        printBlankLine();
    }

    public void printEventBadge(final Badge badge) {
        printBlankLine();
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.println(badge.getName());
    }

    public void printNone() {
        System.out.println(NONE);
    }

    public void printWon(final int amount) {
        System.out.printf(WON, amount);
        printBlankLine();
    }

    public static void printException(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
