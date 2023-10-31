package paramTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceButtonTest extends TestBase {

    static Stream<Arguments> buttonSearch() {
        return Stream.of(
                Arguments.of("Частным лицам", List.of( "ВОЙТИ В ИНТЕРНЕТ-БАНК")),
                Arguments.of("Корпоративным клиентам", List.of("ВОЙТИ В ИНТЕРНЕТ-БАНК")),
                Arguments.of("О банке", List.of("ВОЙТИ В ИНТЕРНЕТ-БАНК"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопки {1} " + ", на странице {0}")
    @Tag("BLOCKER")
    void buttonSearch(String locale, List<String> buttons){
        $$(".top-menu a").find(text(locale)).click();
        $$(".aside-top-menu").filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }

}
