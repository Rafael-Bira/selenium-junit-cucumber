package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BurgerMenu;
import utilities.BaseStep;

public class BurgerMenuSteps extends BaseStep {
    private final BurgerMenu burgerMenu = new BurgerMenu();

    @Then("verify that the Burger Menu links are displayed and enabled")
    public void verifyBurgerMenuLinks() {
        test.info("Verify that the Burger Menu links are displayed and enabled");
        
        WebElement inventoryLink = burgerMenu.getInventoryLink();
        WebElement aboutLink = burgerMenu.getAboutLink();
        WebElement logoutLink = burgerMenu.getLogoutLink();
        WebElement resetLink = burgerMenu.getResetLink();
            
        Assertions.assertAll("Burger Menu UI",
            () -> Assertions.assertTrue(inventoryLink.isDisplayed(), "The All Items link is not displayed"),
            () -> Assertions.assertTrue(inventoryLink.isEnabled(), "The All Items link is not enabled"),
            () -> Assertions.assertTrue(aboutLink.isDisplayed(), "The About link is not displayed"),
            () -> Assertions.assertTrue(aboutLink.isEnabled(), "The About link is not enabled"),
            () -> Assertions.assertTrue(logoutLink.isDisplayed(), "The Logout link is not displayed"),
            () -> Assertions.assertTrue(logoutLink.isEnabled(), "The Logout link is not enabled"),
            () -> Assertions.assertTrue(resetLink.isDisplayed(), "The Reset link is not displayed"),
            () -> Assertions.assertTrue(resetLink.isEnabled(), "The Reset link is not enabled")
        );
    }

    @Then("verify that the About link has the URL {string}")
    public void verifyAboutUrl(String url) {
        test.info("Verify that the About link has the correct URL");
        
        WebElement aboutLink = burgerMenu.getAboutLink();
        Assertions.assertEquals(url, aboutLink.getDomAttribute("href"), "The About URL is not correct");
    }

    @When("user clicks on Logout link")
    public void clickLogoutLink() {
        test.info("User clicks on Logout link");
        
        burgerMenu.getLogoutLink().click();
    }

    @When("user clicks on Reset App State link")
    public void clickResetLink() {
        test.info("User clicks on Reset App State link");
        
        burgerMenu.getResetLink().click();
    }
}
