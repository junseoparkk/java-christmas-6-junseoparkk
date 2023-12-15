package christmas;

import christmas.controller.EventController;
import christmas.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new EventController());
        mainController.process();
    }
}
