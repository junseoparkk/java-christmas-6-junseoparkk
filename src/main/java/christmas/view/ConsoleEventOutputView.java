package christmas.view;

import christmas.model.badge.Badge;
import christmas.model.event.EventCategory;
import christmas.model.menu.GiveawayMenu;

public class ConsoleEventOutputView extends ConsoleOutputView{
    private static final String GIVEAWAY_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String EXPECTED_PAY_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String MINUS_WON = "-" + WON;
    private static final String BENEFIT_DETAILS = "%s: " + MINUS_WON;
    private static final String NONE = "없음";

    public void printGiveawayMenuMessage() {
        System.out.println(GIVEAWAY_MENU_MESSAGE);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printGiveawayMenu(final GiveawayMenu giveawayMenu) {
        String format = MENU_WITH_QUANTITY;
        System.out.printf(format, giveawayMenu.getName(), giveawayMenu.quantity());
        printBlankLine();
        printBlankLine();
    }

    public void printBenefitDetailsMessage() {
        System.out.println(BENEFIT_DETAILS_MESSAGE);
    }

    public void printBenefitDetails(final EventCategory event, final int amount) {
        System.out.printf(BENEFIT_DETAILS, event.getName(), numberFormat.format(amount));
        printBlankLine();
    }

    public void printTotalBenefitAmountMessage() {
        System.out.println(TOTAL_BENEFIT_AMOUNT_MESSAGE);
    }

    public void printTotalBenefitAmount(final int totalBenefitAmount) {
        if (totalBenefitAmount == 0) {
            System.out.printf(WON, totalBenefitAmount);
        }
        if (totalBenefitAmount != 0) {
            System.out.printf(MINUS_WON, numberFormat.format(totalBenefitAmount));
        }
        printBlankLine();
        printBlankLine();
    }

    public void printExpectedPayAmount(final int payAmount) {
        System.out.println(EXPECTED_PAY_AMOUNT_MESSAGE);
        System.out.printf(WON, numberFormat.format(payAmount));
        printBlankLine();
        printBlankLine();
    }

    public void printEventBadge(final Badge badge) {
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.print(badge.getName());
    }

    public void printNone() {
        System.out.print(NONE);
        printBlankLine();
        printBlankLine();
    }
}
