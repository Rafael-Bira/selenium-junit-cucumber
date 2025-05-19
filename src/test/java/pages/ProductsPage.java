package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePage;

public class ProductsPage extends BasePage {   
    // Locators
    private final By title = By.cssSelector("[data-test='title']");
    private final By sortSelect = By.cssSelector("select[data-test='product-sort-container']");
    private final By inventory = By.cssSelector("[data-test='inventory-list']");
    private final By item = By.className("inventory_item");
    private final By itemImg = By.cssSelector("img.inventory_item_img");
    private final By itemName = By.cssSelector("[data-test='inventory-item-name']");
    private final By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By addButton = By.className("btn");

    // Getters
    public WebElement getProductsTitle() {
        return find(title);
    }
    
    public WebElement getSortDropdown() {
        return find(sortSelect);
    }

    public WebElement getInventory() {
        return find(inventory);
    }

    public List<WebElement> getAllItems() {
        return findAll(item);
    }
    
    public WebElement getItemByIndex(int i) {
        return findAll(item).get(i);
    }
    
    public List<WebElement> getAllAddButtons() {
        return findAll(addButton);
    }
    
    public WebElement getAddButtonByIndex(int i) {
        return findAll(addButton).get(i);
    }

    public WebElement getItemImgByIndex(int i) {
        return find(itemImg);
    }

    public List<WebElement> getAllItemsNames() {
        return findAll(itemName);
    }
    
    public List<WebElement> getAllItemsPrices() {
        return findAll(itemPrice);
    }

    // Actions
    public void clickAddButtonByIndex(int i) {
        getAddButtonByIndex(i).click();
    }
    
    public void clickAllAddButtons() {
        List<WebElement> buttonsList = getAllAddButtons();
        for (WebElement button : buttonsList) {
            button.click();
        }
    }

    public void selectOptionByValue(String option) {
        WebElement selectElement = find(sortSelect);
        Select menu = new Select(selectElement);
        menu.selectByValue(option);
    }
}
