package steps;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {
    String
            base_url = "https://alfabank.ru/";

    @Step("Открываем главную страницу Альфа-Банка")
    public void openMainPage() {
        open(base_url);
        refresh();
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
}