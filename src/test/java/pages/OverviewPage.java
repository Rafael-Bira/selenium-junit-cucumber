package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

public class OverviewPage extends BasePage {
    // Locators
    private final By title = By.cssSelector("[data-test='title']");
    private final By quantityLabel = By.cssSelector("[data-test='cart-quantity-label']");
    private final By descLabel = By.cssSelector("[data-test='cart-desc-label']");
    private final By paymentLabel = By.cssSelector("[data-test='payment-info-label']");
    private final By paymentValue = By.cssSelector("[data-test='payment-info-value']");
    private final By shippingLabel = By.cssSelector("[data-test='shipping-info-label']");
    private final By shippingValue = By.cssSelector("[data-test='shipping-info-value']");
    private final By priceLabel = By.cssSelector("[data-test='total-info-label']");
    private final By subtotalLabel = By.cssSelector("[data-test='subtotal-label']");
    private final By taxLabel = By.cssSelector("[data-test='tax-label']");
    private final By totalLabel = By.cssSelector("[data-test='total-label']");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");
    
    private final By item = By.cssSelector("[data-test='inventory-item']");
    private final By itemQuantity = By.cssSelector("[data-test='item-quantity']");
    private final By itemName = By.cssSelector("[data-test='inventory-item-name']");
    private final By itemDesc = By.cssSelector("[data-test='inventory-item-desc']");
    private final By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By removeButton = By.className("btn");

    // Getters
    public WebElement getOverviewTitle() {
        return find(title);
    }

    public WebElement getQuantityLabel() {
        return find(quantityLabel);
    }

    public WebElement getDescLabel() {
        return find(descLabel);
    }

    public WebElement getPaymentLabel() {
        return find(paymentLabel);
    }

    public WebElement getPaymentValue() {
        return find(paymentValue);
    }
    
    public WebElement getShippingLabel() {
        return find(shippingLabel);
    }

    public WebElement getShippingValue() {
        return find(shippingValue);
    }

    public WebElement getPriceLabel() {
        return find(priceLabel);
    }

    public WebElement getSubtotalLabel() {
        return find(subtotalLabel);
    }

    public WebElement getTaxLabel() {
        return find(taxLabel);
    }

    public WebElement getTotalLabel() {
        return find(totalLabel);
    }

    public WebElement getCancelButton() {
        return find(cancelButton);
    }

    public WebElement getFinishButton() {
        return find(finishButton);
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

    public List<WebElement> getAllPrices() {
        return findAll(itemPrice);
    }

    public WebElement getRemoveButtonByIndex(int i) {
        return findAll(removeButton).get(i);
    }

    public List<WebElement> getAllRemoveButtons() {
        return findAll(removeButton);
    }

    // Actions

}
