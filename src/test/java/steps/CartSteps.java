package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utilities.BaseStep;

public class CartSteps extends BaseStep {
    private final CartPage cartPage = new CartPage();

    @Then("verify that the Cart page elements are enabled and correctly displayed")
    public void verifyCartUi() {
        test.info("Verify that the Cart elements are enabled and correctly displayed");

        WebElement title = cartPage.getCartTitle();
        WebElement qtyLabel = cartPage.getQuantityLabel();
        WebElement descLabel = cartPage.getDescLabel();
        WebElement continueBtn = cartPage.getContinueButton();
        WebElement checkoutBtn = cartPage.getCheckoutButton();

        Assertions.assertAll("Cart page UI",
            () -> Assertions.assertEquals("Your Cart", title.getText(), "The page title is incorrect"),
            () -> Assertions.assertTrue(title.isDisplayed(), "The page title is not displayed"),
            () -> Assertions.assertTrue(qtyLabel.isDisplayed(), "The QTY label is not displayed"),
            () -> Assertions.assertTrue(descLabel.isDisplayed(), "The Description label is not displayed"),
            () -> Assertions.assertTrue(continueBtn.isDisplayed(), "The Continue Shopping button is not displayed"),
            () -> Assertions.assertTrue(continueBtn.isEnabled(), "The Continue Shopping button is not enabled"),
            () -> Assertions.assertTrue(checkoutBtn.isDisplayed(), "The Checkout button is not displayed"),
            () -> Assertions.assertTrue(checkoutBtn.isEnabled(), "The Checkout button is not enabled")
        );
    }

    @Then("verify that the item elements are correctly displayed")
    public void verifyItemElements() {
        test.info("Verify that the item elements are correctly displayed");

        int index = 0;

        WebElement itemQty = cartPage.getQuantityByIndex(index);
        WebElement itemName = cartPage.getNameByIndex(index);
        WebElement itemDesc = cartPage.getDescByIndex(index);
        WebElement itemPrice = cartPage.getPriceByIndex(index);
        WebElement removeBtn = cartPage.getRemoveButtonByIndex(index);
    
        Assertions.assertAll("Item elements",
            () -> Assertions.assertTrue(itemQty.isDisplayed(), "The item quantity is not displayed"),
            () -> Assertions.assertTrue(itemName.isDisplayed(), "The item name is not displayed"),
            () -> Assertions.assertTrue(itemDesc.isDisplayed(), "The item description is not displayed"),
            () -> Assertions.assertTrue(itemPrice.isDisplayed(), "The item price is not displayed"),
            () -> Assertions.assertTrue(removeBtn.isDisplayed(), "The Remove button is not displayed"),
            () -> Assertions.assertTrue(removeBtn.isEnabled(), "The Remove button is not enabled")
        );
    }

    @When("clicks the Continue Shopping button")
    public void clickContinueShoppingButton() {
        test.info("User clicks the Continue Shopping button");

        cartPage.getContinueButton().click();
    }

    @Then("verify that the Cart page appears with the correct title")
    public void verifyCartPageTitle() {
        test.info("Verify that the Cart page appears with the correct title");

        String title = cartPage.getCartTitle().getText();
        Assertions.assertEquals("Your Cart", title, "The Cart page title is incorrect");
    }

    @When("clicks the Remove button of the first item")
    public String clickFirstRemoveButton() {
        test.info("User clicks the Remove button of the first item");

        // Get the name of the first item
        String firstName = cartPage.getNameByIndex(0).getText();
        cartPage.getRemoveButtonByIndex(0).click();

        return firstName;
    }

    @Then("verify that now the name of the first item is different")
    public void checkDifferentNames() {
        test.info("Verify that now the name of the first item is different");

        // Get the removed item's name and compare it to the actual first one
        String firstName = clickFirstRemoveButton();
        String actualFirstName =  cartPage.getNameByIndex(0).getText();
        Assertions.assertNotEquals(firstName, actualFirstName, "The names are equal");
    }
}
