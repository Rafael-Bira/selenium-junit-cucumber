package steps;

import io.cucumber.java.en.Given;
import utilities.BaseStep;
import utilities.CommonFlows;

public class CommonSteps extends BaseStep {
    private final CommonFlows commonFlows = new CommonFlows();
    
    @Given("normal user logs in and gets to the Products page")
    public void startSession() {
        test.info("Normal user logs in and gets to the Products page");

        commonFlows.initSession();
    }

    @Given("the user has logged in, added all items and get to the Checkout page")
    public void goToCheckoutPage() {
        test.info("The user has logged in, added all items and get to the Checkout page");

        commonFlows.goToCheckout();
    }

    @Given("user has added all items, completed the checkout form and proceeded to the Overview page")
    public void goToOverviewPage() {
        test.info("User has added all items, completed the checkout form and proceeded to the Overview page");

        commonFlows.goToOverview();
    }

    @Given("the user must have gotten to the Overview page and confirmed the purchase")
    public void goToConfirmationPage() {
        test.info("The user must have gotten to the Overview page and confirmed the purchase");
        
        commonFlows.goToConfirmation();
    }
}
