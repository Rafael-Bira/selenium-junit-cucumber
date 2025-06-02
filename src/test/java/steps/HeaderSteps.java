package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Header;
import utilities.BaseStep;

public class HeaderSteps extends BaseStep {
    private final Header header = new Header();
    
    @Then("verify that the Header elements are correctly displayed and enabled")
    public void verifyHeaderUi() {
        test.info("Verify that the Header elements are correctly displayed and enabled");

        WebElement title = header.getHeaderTitle();
        WebElement cart = header.getCartButton();
        WebElement burgerMenu = header.getBurgerMenuBtn();
        
        Assertions.assertAll("Header UI",
            () -> Assertions.assertTrue(title.isDisplayed(), "The Header title is not displayed"),
            () -> Assertions.assertEquals("Swag Labs", title.getText(), "The Header title is not correct"),
            () -> Assertions.assertTrue(cart.isDisplayed(), "The cart button is not displayed"),
            () -> Assertions.assertTrue(cart.isEnabled(), "The cart button is not enabled"),
            () -> Assertions.assertTrue(burgerMenu.isDisplayed(), "The Burger Menu button is not displayed"),
            () -> Assertions.assertTrue(burgerMenu.isEnabled(), "The Burger Menu button is not enabled")
        );
    }
    
    @Then("verify that the cart icon at the Header displays the number {int}")
    public void checkCartNumber(int number) {
        test.info("Verify that the cart icon at the Header displays the correct number");

        String actualNumber = header.getCartBadge().getText();
        Assertions.assertEquals(number, Integer.parseInt(actualNumber), "The cart number is different");
    }

    @When("user clicks the Burger Menu button")
    public void clickBurgerMenubutton() {
        test.info("User clicks the Burger Menu button");

        header.getBurgerMenuBtn().click();
    }

    @When("user clicks the cart button")
    public void clicCartButton() {
        test.info("User clicks the cart button");

        header.getCartButton().click();
    }

    @Then("the cart icon has no items")
    public void cartHasNoBadge() {
        test.info("The cart icon has no items");
        
        Assertions.assertTrue(header.cartBadgeIsPresent(), "The cart is not empty");
    }
}
