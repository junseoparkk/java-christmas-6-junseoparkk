package christmas.view;

public class OutputView {
    private OutputView() {
    }

    public static void printStartService() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printException(final String message) {
        System.out.println(message);
        printBlankLine();
    }
}
