package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class ConfirmationPage extends BasePage {
    // Locators
    private final By title = By.cssSelector("[data-test='title']");
    private final By confirmIcon = By.cssSelector("[data-test='pony-express']");
    private final By confirmHeader = By.cssSelector("[data-test='complete-header']");
    private final By confirmText = By.cssSelector("[data-test='complete-text']");
    private final By backButton = By.id("back-to-products");

    // Getters
    public WebElement getConfirmationTitle() {
        return find(title);
    }
    
    public WebElement getConfirmIcon() {
        return find(confirmIcon);
    }
    
    public WebElement getConfirmHeader() {
        return find(confirmHeader);
    }
    
    public WebElement getConfirmText() {
        return find(confirmText);
    }
    
    public WebElement getBackButton() {
        return find(backButton);
    }
}
