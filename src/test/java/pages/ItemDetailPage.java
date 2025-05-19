package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class ItemDetailPage extends BasePage {
    // Locators
    private final By backButton = By.id("back-to-products");
    private final By itemImg = By.className("inventory_details_img");
    private final By itemName = By.cssSelector("[data-test='inventory-item-name']");
    private final By itemDesc = By.cssSelector("[data-test='inventory-item-desc']");
    private final By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By addButton = By.id("add-to-cart");

    // Getters
    public WebElement getBackButton() {
        return find(backButton);
    }
    
    public WebElement getItemImg() {
        return find(itemImg);
    }
    
    public WebElement getItemName() {
        return find(itemName);
    }
    
    public WebElement getItemDesc() {
        return find(itemDesc);
    }
    
    public WebElement getItemPrice() {
        return find(itemPrice);
    }
    
    public WebElement getAddButton() {
        return find(addButton);
    }
}
