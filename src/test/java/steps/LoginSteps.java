package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseStep;
import utilities.CommonFlows;

public class LoginSteps extends BaseStep {
    private final LoginPage loginPage = new LoginPage();
    private final CommonFlows commonFlows = new CommonFlows();
    
    @Given("user goes to the Login page")
    public void navigateToLoginPage() {
        test.info("User goes to the Login page");
        
        commonFlows.goToLoginPage();
    }
    
    @When("user fills the form with username {string} and password {string}")
    public void fillForm(String username, String password) {
        test.info("User fills the form with username and password");

        loginPage.login(username, password);
    }
    
    @Then("an error message appears with the text {string}")
    public void verifyErrorMessage(String text) {
        test.info("An error message appears");

        String actualMessage = loginPage.getErrorMessage();
        Assertions.assertEquals(actualMessage, text, "The error message is incorrect");
    }

    @Then("verify that the Login page elements are correctly displayed and enabled")
    public void verifyLoginPageUi() {
        test.info("Verify that the Login page elements are correctly displayed and enabled");

        WebElement title = loginPage.getLoginTitle();
        WebElement username = loginPage.getUsernameInput();
        WebElement password = loginPage.getPasswordInput();
        WebElement loginBtn = loginPage.getLoginButton();

        Assertions.assertAll("Login page UI",
            () -> Assertions.assertTrue(title.isDisplayed(), "The page title is not displayed"),
            () -> Assertions.assertEquals("Swag Labs", title.getText(), "The page title is not correct"),
            () -> Assertions.assertTrue(username.isDisplayed(), "Username input is not displayed"),
            () -> Assertions.assertTrue(username.isEnabled(), "Username input is not enabled"),
            () -> Assertions.assertTrue(password.isDisplayed(), "Password input is not displayed"),
            () -> Assertions.assertTrue(password.isEnabled(), "Password input is not enabled"),
            () -> Assertions.assertTrue(loginBtn.isDisplayed(), "Login button is not displayed"),
            () -> Assertions.assertTrue(loginBtn.isEnabled(), "Login button is not enabled")
        );
    }

    @When("user logs in with username {string} and the common password")
    public void loginValid(String username) {
        test.info("User logs in with username and the common password");
        
        loginPage.login(username, "secret_sauce");
    }

    @Then("verify that the Login page appears with the correct title")
    public void verifyLoginPageTitle() {
        test.info("Verify that the Login page appears with the correct title");

        String title = loginPage.getLoginTitle().getText();
        Assertions.assertEquals("Swag Labs", title, "The Login Page title is incorrect"); 
    }
}
