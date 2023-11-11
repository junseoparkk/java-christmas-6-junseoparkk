package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {
    private static final String REQUEST_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private ConsoleInputView() {
    }

    public static String readExpectedVisitDate() {
        System.out.println(REQUEST_VISIT_DATE_MESSAGE);
        return Console.readLine();
    }
}
