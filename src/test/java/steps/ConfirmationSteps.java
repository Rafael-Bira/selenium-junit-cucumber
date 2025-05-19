package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import utilities.BaseStep;

public class ConfirmationSteps extends BaseStep {
    final ConfirmationPage confirmationPage = new ConfirmationPage();

    @Then("verify that the Confirmation page elements are correctly displayed and enabled")
    public void verifyConfirmationPageUi() {
        test.info("Verify that the Confirmation page elements are correctly displayed and enabled");

        WebElement title = confirmationPage.getConfirmationTitle();
        WebElement confirmIcon = confirmationPage.getConfirmIcon();
        WebElement confirmHeader = confirmationPage.getConfirmHeader();
        WebElement confirmText = confirmationPage.getConfirmText();
        WebElement backBtn = confirmationPage.getBackButton();

        Assertions.assertAll("Confirmation page UI", 
            () -> Assertions.assertEquals("Checkout: Complete!", title.getText(), "The title is not correct"),
            () -> Assertions.assertTrue(title.isDisplayed(), "The title is not displayed"),
            () -> Assertions.assertTrue(confirmIcon.isDisplayed(), "The confirmation icon is not displayed"),
            () -> Assertions.assertTrue(confirmHeader.isDisplayed(), "The confirmation header is not displayed"),
            () -> Assertions.assertTrue(confirmText.isDisplayed(), "The confirmation text is not displayed"),
            () -> Assertions.assertTrue(backBtn.isDisplayed(), "The Back Home is not displayed"),
            () -> Assertions.assertTrue(backBtn.isEnabled(), "The Back Home is not enabled")
        );
    }

    @When("user clicks the Back Home button")
    public void clickBackHomeButton() {
        test.info("User clicks the Back Home button");

        confirmationPage.getBackButton().click();
    }
}
