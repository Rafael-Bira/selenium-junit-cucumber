package steps;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OverviewPage;
import utilities.BaseStep;

public class OverviewSteps extends BaseStep {
    private final OverviewPage overviewPage = new OverviewPage();

    @Then("verify that the Overview page elements are correctly displayed and enabled")
    public void verifyOverviewPageUi() {
        test.info("Verify that the Overview page elements are correctly displayed and enabled");

        WebElement title = overviewPage.getOverviewTitle();
        WebElement qtyLabel = overviewPage.getQuantityLabel();
        WebElement descLabel = overviewPage.getDescLabel();
        WebElement paymentLabel = overviewPage.getPaymentLabel();
        WebElement paymentValue = overviewPage.getPaymentValue();
        WebElement shippingLabel = overviewPage.getShippingLabel();
        WebElement shippingValue = overviewPage.getShippingValue();
        WebElement priceLabel = overviewPage.getPriceLabel();
        WebElement subtotalLabel = overviewPage.getSubtotalLabel();
        WebElement taxLabel = overviewPage.getTaxLabel();
        WebElement totalLabel = overviewPage.getTotalLabel();
        WebElement cancelBtn = overviewPage.getCancelButton();
        WebElement finishBtn = overviewPage.getFinishButton();

        Assertions.assertAll("Overview page UI",
            () -> Assertions.assertEquals("Checkout: Overview", title.getText(), "The title is not correct"),
            () -> Assertions.assertTrue(title.isDisplayed(), "The title is not displayed"),
            () -> Assertions.assertTrue(qtyLabel.isDisplayed(), "The QTY label is not displayed"),
            () -> Assertions.assertTrue(descLabel.isDisplayed(), "The Description label is not displayed"),
            () -> Assertions.assertTrue(paymentLabel.isDisplayed(), "The Payment Information label is not displayed"),
            () -> Assertions.assertTrue(paymentValue.isDisplayed(), "The Payment Value is not displayed"),
            () -> Assertions.assertTrue(shippingLabel.isDisplayed(), "The Shipping Information is not displayed"),
            () -> Assertions.assertTrue(shippingValue.isDisplayed(), "The Shipping Value is not displayed"),
            () -> Assertions.assertTrue(priceLabel.isDisplayed(), "The Price Total label is not displayed"),
            () -> Assertions.assertTrue(subtotalLabel.isDisplayed(), "The Item total label is not displayed"),
            () -> Assertions.assertTrue(taxLabel.isDisplayed(), "The Tax label is not displayed"),
            () -> Assertions.assertTrue(totalLabel.isDisplayed(), "The Total label is not displayed"),
            () -> Assertions.assertTrue(cancelBtn.isDisplayed(), "The Cancel button is not displayed"),
            () -> Assertions.assertTrue(cancelBtn.isEnabled(), "The Cancel button is not enabled"),
            () -> Assertions.assertTrue(finishBtn.isDisplayed(), "The Finish button is not displayed"),
            () -> Assertions.assertTrue(finishBtn.isEnabled(), "The Finish button is not enabled")
        );
    }

    @When("user sums all prices of the items")
    public float sumAllPrices() {
        test.info("User sums all prices of the items");
        
        float sum = 0.00f;

        List<WebElement> pricesList = overviewPage.getAllPrices();
        for (WebElement price : pricesList) {
            String text = price.getText();
            // Remove the $ character
            text = text.replace("$", "");
            // Convert String to float and add it to the sum
            sum += Float.parseFloat(text);
        }

        return sum;
    }

    @Then("verify that the Item total and Total values are correct")
    public void checkItemTotalAndTotalValues() {
        test.info("Verify that the Item total and Total values are correct");
        
        float expectedSubtotal = sumAllPrices();
        
        String subtotalText = overviewPage.getSubtotalLabel().getText();
        // Remove the text and convert the number to float
        subtotalText = subtotalText.replace("Item total: $", "");
        float actualSubtotal = Float.parseFloat(subtotalText);

        Assertions.assertEquals(expectedSubtotal, actualSubtotal, "The Item total value is incorrect");

        // Get the tax text, convert it to float and sum the expected total price
        String taxText = overviewPage.getTaxLabel().getText();
        taxText = taxText.replace("Tax: $", "");
        float tax = Float.parseFloat(taxText);
        float expectedTotal = expectedSubtotal + tax;

        String totalText = overviewPage.getTotalLabel().getText();
        // Remove the text and convert to float
        totalText = totalText.replace("Total: $", "");
        float actualTotal = Float.parseFloat(totalText);

        Assertions.assertEquals(expectedTotal, actualTotal, "The Total value is incorrect");
    }

    @Then("the Overview page appears with the correct title")
    public void verifyOverviewTitle() {
        test.info("The Overview page appears with the correct title");

        String title = overviewPage.getOverviewTitle().getText();
        Assertions.assertEquals("Checkout: Overview", title, "The Overview page title is incorrect");
    }

    @When("user clicks on the first item name")
    public String clickFirstItemName() {
        test.info("User clicks on the first item name");

        WebElement firstItem = overviewPage.getNameByIndex(0);
        // Get the name of the first item
        String itemName = firstItem.getText();
        firstItem.click();

        return itemName;
    }

    @When("user clicks the Overview Cancel button")
    public void clickOverviewCancelButton() {
        test.info("User clicks the Overview Cancel button");

        overviewPage.getCancelButton().click();
    }
}
