package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class LoginPage extends BasePage {
    // Locators
    private final By loginTitle = By.className("login_logo");
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");    

    // Getters 
    public WebElement getLoginTitle() {
        return find(loginTitle);
    }
    
    public WebElement getUsernameInput() {
        return find(usernameInput);
    }

    public WebElement getPasswordInput() {
        return find(passwordInput);
    }

    public WebElement getLoginButton() {
        return find(loginButton);
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    // Actions
    public void login(String username, String password) {
        find(usernameInput).sendKeys(username);
        find(passwordInput).sendKeys(password);
        find(loginButton).click();
    }
}