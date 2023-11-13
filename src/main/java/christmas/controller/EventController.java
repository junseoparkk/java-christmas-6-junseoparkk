package christmas.controller;

import static christmas.model.menu.MenuItem.NONE;

import christmas.ApplicationConfig;
import christmas.model.menu.GiveawayMenu;
import christmas.service.EventService;
import christmas.view.ConsoleOutputView;

public class EventController implements Controller {
    private final ConsoleOutputView outputView;
    private final EventService eventService;

    public EventController(final ApplicationConfig applicationConfig) {
        outputView = applicationConfig.consoleOutputView();
        eventService = applicationConfig.eventService();
    }

    @Override
    public void run() {
        proceedEvent();
        printGivenMenu();
        printBenefitDetails();
        printTotalBenefitAmount();
        printExpectedPayAmount();
        printEventBadge();
    }

    private void proceedEvent() {
        eventService.proceed();
    }

    private void printGivenMenu() {
        outputView.printGiveawayMenuMessage();
        GiveawayMenu giveawayMenu = eventService.getGiveMenu();
        if (giveawayMenu.item() == NONE) {
            outputView.printNone();
            return;
        }
        outputView.printGiveawayMenu(giveawayMenu);
    }

    private void printBenefitDetails() {
    }

    private void printTotalBenefitAmount() {
    }

    private void printExpectedPayAmount() {
    }

    private void printEventBadge() {
    }
}
