package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class CartPage extends BasePage {
    // Locators
    private final By title = By.cssSelector("[data-test='title']");
    private final By quantityLabel = By.cssSelector("[data-test='cart-quantity-label']");
    private final By descLabel = By.cssSelector("[data-test='cart-desc-label']");
    private final By continueButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    
    private final By item = By.cssSelector("[data-test='inventory-item']");
    private final By itemQuantity = By.cssSelector("[data-test='item-quantity']");
    private final By itemName = By.cssSelector("[data-test='inventory-item-name']");
    private final By itemDesc = By.cssSelector("[data-test='inventory-item-desc']");
    private final By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By removeButton = By.className("btn");

    // Getters
    public WebElement getCartTitle() {
        return find(title);
    }

    public WebElement getQuantityLabel() {
        return find(quantityLabel);
    }

    public WebElement getDescLabel() {
        return find(descLabel);
    }
    
    public WebElement getContinueButton() {
        return find(continueButton);
    }

    public WebElement getCheckoutButton() {
        return find(checkoutButton);
    }
    
    // Items
    public WebElement getItemByIndex(int i) {
        return findAll(item).get(i);
    }
    
    public List<WebElement> getAllItems() {
        return findAll(item);
    }

    public WebElement getQuantityByIndex(int i) {
        return findAll(itemQuantity).get(i);
    }
    
    public WebElement getNameByIndex(int i) {
        return findAll(itemName).get(i);
    }
    
    public WebElement getDescByIndex(int i) {
        return findAll(itemDesc).get(i);
    }
    
    public WebElement getPriceByIndex(int i) {
        return findAll(itemPrice).get(i);
    }

    public WebElement getRemoveButtonByIndex(int i) {
        return findAll(removeButton).get(i);
    }

    public List<WebElement> getAllRemoveButtons() {
        return findAll(removeButton);
    }
}
