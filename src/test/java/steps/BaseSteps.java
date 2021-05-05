package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {
    String
            base_url = "https://alfabank.ru/";

    @Step("Открываем главную страницу Альфа-Банка")
    public void openMainPage() {
        open(base_url);
    }

    @Step("Клик на поле поиска")
    public void clickOnSearch() {
        $(byXpath("//div[3]/div[1]/div[1]/img")).click();
    }

    @Step("Вставляем в поле поиска текст и нажимаем Enter")
    public void insertTextOnSearchAndPressEnter() {
        $("[type=search]").setValue("Вклады").pressEnter();
    }

    @Step("Проверяем что в результатах поиска более 1 или более ответов")
    public void checkResult() {
        $$(".b-serp-item").shouldHave(size(5));
    }

    @Step("Клик на Вклады")
    public void depositTitleClick() {
        $("[title=Вклады]").click();
    }

    @Step("Клик на Вклады")
    public void depositButtonClick() {
        $$("[type=button]").findBy(text("Депозиты")).click();
    }

    @Step("Проверка что доступных вкладов больше 1")
    public void checkEqualDepositAndText() {
        $$("#alfa-deposit").shouldHave(sizeGreaterThanOrEqual(1));
        $$("[data-widget-name=Heading]").get(0).shouldHave(text("Вклады"));
    }

    @Step("Клик на кнопку Обратная связь")
    public void feedbackButtonClick() {
        $("#alfa").$(byTitle("Обратная связь")).click();
    }

    @Step("Заполнение формы данными")
    public void fillFormFeedback() {
        $("#alfa").$(byName("name")).setValue("Тестировщик Тест Тестович");
        $$("[type=tel]").get(0).setValue("07031997");
        $("[data-test-id=phoneInput]").setValue("9727777777");
        $("[name=contactEmail]").setValue("maksimdemsky@gmail.com");
        $("#alfa").$(byValue("Задать вопрос/рассказать о проблеме")).click();
        $("[role=listbox]").$(byText("Выразить благодарность")).click();
        $("[name=gratitude]").setValue("Привет! Это автотест для АльфаБанка.");
        //Строка закоменчена, чтобы настроящая форма не отправлялась.
        //$("#feedback div > label > div").click();
    }

    @Step("Нажатие на кнопку Продолжить")
    public void clickSubmit() {
        $("#feedback").$("[type=submit]").click();
    }

    @Step("Проверка что текст ошибки появился")
    public void checkErrorMessage() {
        $("#feedback").shouldBe(text("Чтобы продолжить, необходимо ваше согласие"));
    }
}