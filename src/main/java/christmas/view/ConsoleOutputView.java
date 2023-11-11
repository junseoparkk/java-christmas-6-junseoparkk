package christmas.view;

public class ConsoleOutputView {
    private static final String EVENT_PLANNER_GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFIT_GUIDE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public void printGreeting() {
        System.out.println(EVENT_PLANNER_GREETING_MESSAGE);
    }

    public void printEventBenefitGuide(final int date) {
        System.out.printf(EVENT_BENEFIT_GUIDE_MESSAGE, date);
        printBlankLine();
    }

    public static void printException(final String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
