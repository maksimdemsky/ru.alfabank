package tests;

import org.junit.jupiter.api.Test;
import steps.BaseSteps;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchTests {
    public BaseSteps steps = new BaseSteps();

    @Test
    void checkSearchResultTest () {
        steps.openMainPage();
        steps.clickOnSearch();
        steps.insertTextOnSearchAndPressEnter();
        steps.checkResult();
    }
}
