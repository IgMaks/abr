package paramTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class ValueSourceSidebarTest {

    @BeforeEach
    void menuOpen() {
        open("https://abr.ru/");
        Configuration.holdBrowserOpen = false;
    }

    @ValueSource(strings = {
            "Войти в интернет-банк",
            "Онлайн-заявка на кредит",
            "Стать клиентом",
            "Онлайн-платежи за газ"
    })

    @ParameterizedTest(name = "Наличие раздела {0}, в сайдбаре на сайте abr.ru")
    @Tag("HIGH")
    void sidebarValueTest(String value) {
        $$(".s").shouldHave(CollectionCondition.texts(value));
    }
}
