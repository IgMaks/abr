package paramTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class ValueSourceSidebarTest extends TestBase {
    @Disabled
    @Feature("Проверка сайдбара")
    @Owner("I.Max")
    @DisplayName("Проверка разделов в сайдбаре")
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
