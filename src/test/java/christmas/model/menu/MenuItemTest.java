package christmas.model.menu;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuItemTest {
    @DisplayName("존재하지 않는 메뉴이면 거짓을 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"연어샐러드", "바비큐폭립", "토마토파스타", "팥빙수", "소주"})
    void testMenuItemByNotExistMenu(String menuItem) {
        //when, then
        assertThat(MenuItem.exists(menuItem)).isFalse();
    }

    @DisplayName("존재하는 메뉴이면 참을 반환해야 한다.")
    @Test
    void testMenuItemByExistMenu() {
        //given
        List<String> items = Arrays.asList(MenuItem.values()).stream()
                .map(MenuItem::getName)
                .collect(Collectors.toList());

        //when, then
        assertThat(items.stream()
                .allMatch(item -> MenuItem.exists(item)))
                .isTrue();
    }
}
