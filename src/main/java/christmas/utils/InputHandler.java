package christmas.utils;

import christmas.utils.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputHandler {
    private InputHandler() {
    }

    public static int receiveVisitDay() {
        return receiveValidatedInput(
                InputView::readVisitDay,
                InputValidator::validateVisitDay,
                Integer::parseInt
        );
    }

    private static <T> T receiveValidatedInput(
            Supplier<String> supplier,
            Consumer<String> validator,
            Function<String, T> converter
    ) {
        while (true) {
            try {
                String input = supplier.get();
                validator.accept(input);
                return converter.apply(input);
            } catch (IllegalArgumentException e) {
                OutputView.printException(e.getMessage());
            }
        }
    }
}
