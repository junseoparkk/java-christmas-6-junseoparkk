package christmas.model.menu;

public record GiveawayMenu(MenuItem item, int quantity) {
    public String getName() {
        return item.getName();
    }
}
