package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class Header extends BasePage {
    // Locators
    private final By headerTitle = By.className("app_logo");
    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    
    // Getters
    public WebElement getHeaderTitle() {
        return find(headerTitle);
    }
    
    public WebElement getCartButton() {
        return find(cartButton);
    }
    
    public WebElement getCartBadge() {
        return find(cartBadge);
    }
    
    public WebElement getBurgerMenuBtn() {
        return find(burgerMenuButton);
    }

    // Actions
    // Check if the cart badge element exists
    public boolean cartBadgeIsPresent() {
        List<WebElement> elements = findAll(cartBadge);
        return elements.isEmpty();
    }
}
