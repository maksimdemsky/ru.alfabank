package tests;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import steps.BaseSteps;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchTests extends TestBase {
    public BaseSteps steps = new BaseSteps();

    @Test
    @Name("Проверка формы поиска")
    void checkSearchResultTest() {
        steps.openMainPage();
        steps.clickOnSearch();
        steps.insertTextOnSearchAndPressEnter();
        steps.checkResult();
    }
}
