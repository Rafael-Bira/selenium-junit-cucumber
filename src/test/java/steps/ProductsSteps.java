package steps;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.ProductsPage;
import utilities.BaseStep;

public class ProductsSteps extends BaseStep {
    private final ProductsPage productsPage = new ProductsPage();

    @Then("verify that the Products page elements are correctly displayed and enabled")
    public void verifyProductsPageUi() {
        test.info("Verify that the Products page elements are correctly displayed and enabled");

        WebElement title = productsPage.getProductsTitle();
        WebElement sortDropdown = productsPage.getSortDropdown();
        WebElement inventory = productsPage.getInventory();
        List<WebElement> itemsList = productsPage.getAllItems();
        List<WebElement> buttonsList = productsPage.getAllAddButtons();
        
        // Make a List of Executables to gather assertions 
        List<Executable> uiAsserts = new ArrayList<>();
        
        // Check if the Add buttons are all enabled and add these assertions
        for (WebElement button : buttonsList) {
            uiAsserts.add(() -> Assertions.assertTrue(button.isDisplayed(), "An Add to cart button is not displayed"));
            uiAsserts.add(() -> Assertions.assertTrue(button.isEnabled(), "An Add to cart button is not enabled"));
        }
        
        // Add the rest of the assertions
        uiAsserts.add(() -> Assertions.assertTrue(title.isDisplayed(), "The page title is not displayed"));
        uiAsserts.add(() -> Assertions.assertEquals("Products", title.getText(), "The page title is not correct"));
        uiAsserts.add(() -> Assertions.assertTrue(inventory.isDisplayed(), "The inventory list is not displayed"));
        uiAsserts.add(() -> Assertions.assertEquals(6, itemsList.size(), "The number of items is not correct"));
        uiAsserts.add(() -> Assertions.assertEquals(6, buttonsList.size(), "The number of buttons is not correct"));
        uiAsserts.add(() -> Assertions.assertTrue(sortDropdown.isDisplayed(), "The Sort dropdown is not displayed"));
        
        Assertions.assertAll("Products page UI", uiAsserts.stream());
    }
    
    @When("user clicks every Add to cart button")
    public void clickEveryAddButton() {
        test.info("User clicks every Add to cart button");
        
        productsPage.clickAllAddButtons();
    }
    
    @Then("the button text changes to {string}")
    public void checkButtonTextChange(String text) {
        test.info("The button text changes");
        
        List<Executable> btnAsserts = new ArrayList<>();
        
        // We must use the buttons' locator again because the states have changed
        List<WebElement> buttons = productsPage.getAllAddButtons();
        for (WebElement button : buttons) {
            btnAsserts.add(() -> Assertions.assertEquals(text, button.getText()));
        }

        Assertions.assertAll("Button text", btnAsserts.stream());
    }
    
    @Then("verify that the Products page appears with the correct title")
    public void verifyProductsTitle() {
        test.info("Verify that the Products page appears with the correct title");
        
        String title = productsPage.getProductsTitle().getText();
        Assertions.assertEquals("Products", title, "The Products page title is incorrect");
    }
    
    @And("goes to Item Detail page")
    public void goToItemDetailPage() {
        test.info("User goes to Item Detail page");

        productsPage.getItemImgByIndex(0).click();
    }

    @When("user selects {string} from the Sort dropdown")
    public void selectSortOption(String option) {
        test.info("User selects an option from the Sort dropdown");

        productsPage.selectOptionByValue(option);
    }

    @Then("the first item is {string} and the last is {string}")
    public void checkFirstAndLastNames(String first, String last) {
        test.info("The first and last items are shown");
        
        List<WebElement> namesList = productsPage.getAllItemsNames();
        WebElement firstName = namesList.get(0);
        WebElement lastName = namesList.get(namesList.size() - 1);

        Assertions.assertAll("Check first and last names",
            () -> Assertions.assertEquals(first, firstName.getText(), "The first name is not correct"),
            () -> Assertions.assertEquals(last, lastName.getText(), "The last name is not correct")
        );
    }
    
    @Then("the first price is {string} and the last is {string}")
    public void checkFirstAndLastPrices(String first, String last) {
        test.info("The first and last prices are shown");
        
        List<WebElement> pricesList = productsPage.getAllItemsPrices();
        WebElement firstPrice = pricesList.get(0);
        WebElement lastPrice = pricesList.get(pricesList.size() - 1);

        Assertions.assertAll("Check first and last prices",
            () -> Assertions.assertEquals(first, firstPrice.getText(), "The first price is not correct"),
            () -> Assertions.assertEquals(last, lastPrice.getText(), "The last price is not correct")
        );
    }

    @Then("the corresponding button text should be {string}")
    public void checkAddButtonText(String text) {
        test.info("The corresponding button text is shown");

        String actualText = productsPage.getAddButtonByIndex(0).getText();
        Assertions.assertEquals(text, actualText, "The button text is different");
    }

    @When("user clicks on the first Add to cart button")
    public void clickFirstAddButton() {
        test.info("User clicks on the first Add to cart button");
        
        productsPage.getAddButtonByIndex(0).click();
    }
}
