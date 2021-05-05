package tests;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class FeedbackTests extends TestBase {
    public BaseSteps steps = new BaseSteps();

    @Test
    @Name("Проверка заполнения формы обратной связи")
    void createFeedbackMessageAndCheckError() {
        steps.openMainPage();
        steps.feedbackButtonClick();
        steps.fillFormFeedback();
        steps.clickSubmit();
        steps.checkErrorMessage();
    }
}
