package christmas.view;

import christmas.model.OrderLineItem;
import christmas.model.OrderLineItems;

public class OutputView {
    private OutputView() {
    }

    public static void printStartService() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printInformationMessage(final int visitDay) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitDay);
        printBlankLine();
        printBlankLine();
    }

    public static void printAllMenus(final OrderLineItems orderLineItems) {
        System.out.println("<주문 메뉴>");
        for (int i = 0; i < orderLineItems.size(); i++){
            OrderLineItem item = orderLineItems.findOrderLineItemByIndex(i);
            System.out.println(item.toString());
        }
        printBlankLine();
    }

    public static void printTotalAmount(final int amount) {
        System.out.println("<할인 전 총주문 금액>");
        String formattedAmount = String.format("%,d", amount);
        System.out.println(formattedAmount + "원");
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printException(final String message) {
        System.out.println(message);
        printBlankLine();
    }
}
