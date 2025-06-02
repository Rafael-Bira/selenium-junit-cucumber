package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import utilities.BaseStep;

public class CheckoutSteps extends BaseStep {
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @Then("verify that the Checkout page elements are correctly displayed and enabled")
    public void verifyCheckoutPageUi() {
        test.info("Verify that the Checkout page elements are correctly displayed and enabled");

        WebElement title = checkoutPage.getCheckoutTitle();
        WebElement firstName = checkoutPage.getFirstNameInput();
        WebElement lastName = checkoutPage.getLastNameInput();
        WebElement postalCode = checkoutPage.getPostalCodeInput();
        WebElement cancelBtn = checkoutPage.getCancelButton();
        WebElement continueBtn = checkoutPage.getContinueButton();
    
        Assertions.assertAll("Checkout page UI",
            () -> Assertions.assertEquals("Checkout: Your Information", title.getText(), "The title is not correct"),
            () -> Assertions.assertTrue(title.isDisplayed(), "The title is not displayed"),
            () -> Assertions.assertTrue(firstName.isDisplayed(), "The First Name input is not displayed"),
            () -> Assertions.assertTrue(firstName.isEnabled(), "The First Name input is not enabled"),
            () -> Assertions.assertTrue(lastName.isDisplayed(), "The Last Name input is not displayed"),
            () -> Assertions.assertTrue(lastName.isEnabled(), "The Last Name input is not enabled"),
            () -> Assertions.assertTrue(postalCode.isDisplayed(), "The Postal Code input is not displayed"),
            () -> Assertions.assertTrue(postalCode.isEnabled(), "The Postal Code input is not enabled"),
            () -> Assertions.assertTrue(cancelBtn.isDisplayed(), "The Cancel button input is not displayed"),
            () -> Assertions.assertTrue(cancelBtn.isEnabled(), "The Cancel button input is not enabled"),
            () -> Assertions.assertTrue(continueBtn.isDisplayed(), "The Continue button input is not displayed"),
            () -> Assertions.assertTrue(continueBtn.isEnabled(), "The Continue button input is not enabled")
        );
    }

    @When("user clicks the Cancel button")
    public void clickCancelButton() {
        test.info("User clicks the Cancel button");

        checkoutPage.getCancelButton().click();
    }

    @Then("user clicks the Continue button leaving all inputs empty")
    public void clickContinueButton() {
        test.info("User clicks the Continue button leaving all inputs empty");

        checkoutPage.getContinueButton().click();
    }

    @When("user fills the form with {string}, {string} and {string} and clicks the Continue button")
    public void fillForm(String firstName, String lastName, String postalCode) {
        test.info("User fills the form and clicks the Continue button");
        
        checkoutPage.fillCheckoutForm(firstName, lastName, postalCode);
    }

    @Then("a message appears with the text {string}")
    public void verifyErrorMessage(String text) {
        test.info("A message appears");
        
        String actualMessage = checkoutPage.getErrorMessage();
        Assertions.assertEquals(actualMessage, text, "The error message is incorrect");
    }
}
