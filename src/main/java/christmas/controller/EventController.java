package christmas.controller;

import christmas.ApplicationConfig;
import christmas.model.badge.Badge;
import christmas.model.event.EventCategory;
import christmas.model.menu.GiveawayMenu;
import christmas.model.menu.MenuItem;
import christmas.service.EventService;
import christmas.view.ConsoleEventOutputView;
import java.util.Map;

public class EventController implements Controller {
    private final ConsoleEventOutputView outputView;
    private final EventService eventService;

    public EventController(final ApplicationConfig applicationConfig) {
        outputView = applicationConfig.consoleEventOutputView();
        eventService = applicationConfig.eventService();
    }

    @Override
    public void run() {
        proceedEvent();
        printGiveawayMenu();
        printBenefitDetails();
        printTotalBenefitAmount();
        printExpectedPayAmount();
        printEventBadge();
    }

    private void proceedEvent() {
        eventService.proceed();
    }

    private void printGiveawayMenu() {
        GiveawayMenu giveawayMenu = eventService.getGiveawayMenu();
        outputView.printGiveawayMenuMessage();
        if (giveawayMenu.item() == MenuItem.NONE) {
            outputView.printNone();
            return;
        }
        outputView.printGiveawayMenu(giveawayMenu);
    }

    private void printBenefitDetails() {
        outputView.printBenefitDetailsMessage();
        if (eventService.isNotAppliedEvent()) {
            outputView.printNone();
            return;
        }
        printAllBenefitDetails();
        outputView.printBlankLine();
    }

    private void printAllBenefitDetails() {
        Map<EventCategory, Integer> result = eventService.getAllEvents();
        result.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .forEach(entry -> {
                    outputView.printBenefitDetails(entry.getKey(), entry.getValue());
                });
    }

    private void printTotalBenefitAmount() {
        int totalBenefitAmount = eventService.calculateTotalBenefitAmount();
        outputView.printTotalBenefitAmountMessage();
        outputView.printTotalBenefitAmount(totalBenefitAmount);
    }

    private void printExpectedPayAmount() {
        int payAmount = eventService.calculatePayAmount();
        outputView.printExpectedPayAmount(payAmount);
    }

    private void printEventBadge() {
        Badge badge = eventService.getEventBadge();
        outputView.printEventBadge(badge);
    }
}
