package christmas.view;

import java.text.DecimalFormat;

public class ConsoleOrderOutputView extends ConsoleOutputView{
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private static final String EVENT_BENEFIT_GUIDE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>";

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
        printBlankLine();
    }
}
