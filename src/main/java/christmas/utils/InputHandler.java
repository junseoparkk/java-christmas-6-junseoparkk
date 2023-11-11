package christmas.utils;

import christmas.model.order.OrderLineItems;
import christmas.validator.InputValidator;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleOutputView;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {
    private InputHandler() {
    }

    public static int receiveValidatedVisitDate() {
        return receiveValidatedInput(
                ConsoleInputView::readExpectedVisitDate,
                InputValidator::validateDateForm,
                Integer::parseInt);
    }

    public static OrderLineItems receiveValidatedOrderItems() {
        return receiveValidatedInput(
                ConsoleInputView::readOrderLineItems,
                InputValidator::validateOrderForm,
                OrderLineItems::new);
    }

    private static <T> T receiveValidatedInput(
            Supplier<String> inputSupplier,
            Consumer<String> validator,
            Function<String, T> resultConverter
    ) {
        while (true) {
            try {
                String input = inputSupplier.get();
                validator.accept(input);
                return resultConverter.apply(input);
            } catch (IllegalArgumentException e) {
                ConsoleOutputView.printException(e.getMessage());
            }
        }
    }
}
