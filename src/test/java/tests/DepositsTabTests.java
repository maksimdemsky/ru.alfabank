package tests;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class DepositsTabTests extends TestBase {
    public BaseSteps steps = new BaseSteps();

    @Test
    @Name("Проверка открытия вкладки с Депозитами")
    void checkDepositTabOpen() {
        steps.openMainPage();
        steps.depositTitleClick();
        steps.depositButtonClick();
        steps.checkEqualDepositAndText();
    }
}
