package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemDetailPage;
import utilities.BaseStep;

public class ItemDetailSteps extends BaseStep {
    private final ItemDetailPage itemPage = new ItemDetailPage();
    
    @Then("verify that the Item Detail page elements are correctly displayed and enabled")
    public void verifyItemDetailPageUi() {
        test.info("Verify that the Item Detail page elements are correctly displayed and enabled");

        WebElement backButton = itemPage.getBackButton();
        WebElement itemImg = itemPage.getItemImg();
        WebElement itemName = itemPage.getItemName();
        WebElement itemDesc = itemPage.getItemDesc();
        WebElement itemPrice = itemPage.getItemPrice();
        WebElement addButton = itemPage.getAddButton();
        
        Assertions.assertAll("Item Detail page UI",
            () -> Assertions.assertTrue(backButton.isDisplayed(), "The Back to products button is not displayed"),
            () -> Assertions.assertTrue(backButton.isEnabled(), "The Back to products button is not enabled"),
            () -> Assertions.assertTrue(itemImg.isDisplayed(), "The item image is not displayed"),
            () -> Assertions.assertTrue(itemName.isDisplayed(), "The item name is not displayed"),
            () -> Assertions.assertTrue(itemDesc.isDisplayed(), "The item description is not displayed"),
            () -> Assertions.assertTrue(itemPrice.isDisplayed(), "The item price is not displayed"),
            () -> Assertions.assertTrue(addButton.isDisplayed(), "The Add to cart button is not displayed"),
            () -> Assertions.assertTrue(addButton.isEnabled(), "The Add to cart button is not enabled")
        );
    }
        
    @When("user clicks the Back to products button")
    public void clickBackButton() {
        test.info("User clicks the Back to products button");

        WebElement backButton = itemPage.getBackButton();
        backButton.click();
    }
    
    @When("user clicks the Add to cart button")
    public void clickAddButton() {
        test.info("User clicks on the Add to cart button");

        WebElement addButton = itemPage.getAddButton();
        addButton.click();
    }

    @Then("verify that the item name is the same")
    public void verifySameItemName() {
        test.info("Verify that the item name is the same");

        // Get the name of the first item at the Overview page and compare it with the one on this page 
        String overviewItemName = new OverviewSteps().clickFirstItemName();
        String itemName = itemPage.getItemName().getText();
        Assertions.assertEquals(overviewItemName, itemName, "The names are not equal");
    }
}
