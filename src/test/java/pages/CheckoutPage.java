package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class CheckoutPage extends BasePage {
    // Locators
    private final By title = By.cssSelector("[data-test='title']");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // Getters
    public WebElement getCheckoutTitle() {
        return find(title);
    }
    
    public WebElement getFirstNameInput() {
        return find(firstName);
    }
    
    public WebElement getLastNameInput() {
        return find(lastName);
    }
    
    public WebElement getPostalCodeInput() {
        return find(postalCode);
    }
    
    public WebElement getCancelButton() {
        return find(cancelButton);
    }
    
    public WebElement getContinueButton() {
        return find(continueButton);
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    // Actions
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        getFirstNameInput().sendKeys(firstName);
        getLastNameInput().sendKeys(lastName);
        getPostalCodeInput().sendKeys(postalCode);
        getContinueButton().click();
    }
}