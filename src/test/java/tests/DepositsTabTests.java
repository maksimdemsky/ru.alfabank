package tests;

import org.junit.jupiter.api.Test;
import steps.BaseSteps;

public class DepositsTabTests {
    public BaseSteps steps = new BaseSteps();

    @Test
    void checkDepositTabOpen() {
        steps.openMainPage();
        steps.depositTitleClick();
        steps.depositButtonClick();
        steps.checkEqualDepositAndText();
    }
}
