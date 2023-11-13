package christmas.view;

import java.text.DecimalFormat;

public class ConsoleOutputView {
    private static final String EVENT_PLANNER_GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    protected static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    protected static final String WON = "%s원";
    protected static final String MENU_WITH_QUANTITY = "%s %d개";

    public static void printException(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void printGreeting() {
        System.out.println(EVENT_PLANNER_GREETING_MESSAGE);
    }

    protected void printBlankLine() {
        System.out.println();
    }
}
