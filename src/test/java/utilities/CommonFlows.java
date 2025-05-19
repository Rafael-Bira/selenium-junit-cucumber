package utilities;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Header;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductsPage;

public class CommonFlows {
    protected WebDriver useDriver() {
        new DriverProvider();
        return DriverProvider.get();
    }

    // 1 - Navigate to Login Page
    public void goToLoginPage() {
        useDriver().get("https://www.saucedemo.com/");
    }

    // 2 - Login
    public void initSession() {
        goToLoginPage();
        new LoginPage().login("standard_user", "secret_sauce");
    }

    // 3 - Add all products to the cart and proceed to the checkout page
    public void goToCheckout() {
        initSession();
        new ProductsPage().clickAllAddButtons();
        new Header().getCartButton().click();
        new CartPage().getCheckoutButton().click();
    }

    // 4 - After checkout, proceed to Overview page
    public void goToOverview() {
        goToCheckout();
        new CheckoutPage().fillCheckoutForm("John", "Doe", "1234");
    }

    // 5 - After overviewing the purchase, proceed to the Confirmation page
    public void goToConfirmation() {
        goToOverview();
        new OverviewPage().getFinishButton().click();
    }
}
