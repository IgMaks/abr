package paramTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;


public class CsvSourceMenuTest extends TestBase {
    @CsvSource({
            "Частным лицам",
            "Кредиты",
            "Вклады",
            "Банковские счета и переводы",
            "Комплексное банковское обслуживание",
            "Банковские карты",
            "Дополнительные услуги и продукты",
            "Операции на рынке ценных бумаг",
            "Депозитарные услуги",
            "Дистанционное обслуживание",
            "Журнал «Алые паруса»",
            "Удаленная идентификация по биометрии",
            "Корпоративным клиентам",
            "Расчетно-кассовое обслуживание (РКО)",
            "Банковское сопровождение контрактов",
            "Размещение денежных средств",
            "Зарплатный проект",
            "Эквайринг и СБП",
            "Кредитование",
            "Дистанционное обслуживание",
            "Депозитарные услуги",
            "Операции на рынке ценных бумаг",
            "Документарные операции",
            "Управление расчетами и ликвидностью",
            "Другие услуги",
            "О банке",
            "История",
            "Миссия",
            "Пресс-релизы и события",
            "Корпоративное управление",
            "Позиции в рейтингах",
            "Реквизиты Банка",
            "Раскрытие информации",
            "Контактная информация",
            "Корпоративная отчетность",
            "ПОД/ФТ",
            "Вакансии",
            "Оценка качества"
    })

    @ParameterizedTest(name = "Проверка таба \"{0}\" в топ меню")
    @Tag("Bug")
    void checkHeaderModuleLinks(String link) {
        $$(".top-menu").shouldHave(CollectionCondition.texts(link));
    }

}

