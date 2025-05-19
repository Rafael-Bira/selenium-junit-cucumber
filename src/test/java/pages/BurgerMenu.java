package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class BurgerMenu extends BasePage {
    // Locators
    private final By inventoryLink = By.id("inventory_sidebar_link");
    private final By aboutLink = By.id("about_sidebar_link");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By resetLink = By.id("reset_sidebar_link");

    // Getters
    public WebElement getInventoryLink() {
        return find(inventoryLink);
    }

    public WebElement getAboutLink() {
        return find(aboutLink);
    }
    
    public WebElement getLogoutLink() {
        return find(logoutLink);
    }
    
    public WebElement getResetLink() {
        return find(resetLink);
    }
}
