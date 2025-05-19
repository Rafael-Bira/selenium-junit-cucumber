package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import pages.Footer;
import utilities.BaseStep;

public class FooterSteps extends BaseStep {
    private final Footer footer = new Footer();           

    @Then("verify that the Footer elements are correctly displayed and enabled")
    public void verifyFooterUi() {
        test.info("Verify that the Footer elements are correctly displayed and enabled");

        WebElement twitter = footer.getTwitter();
        WebElement facebook = footer.getFacebook();
        WebElement linkedin = footer.getLinkedin();    
        WebElement copyright = footer.getCopyright();   

        Assertions.assertAll("Footer UI",
            () -> Assertions.assertTrue(twitter.isDisplayed(), "The Twitter link is not displayed"),
            () -> Assertions.assertTrue(twitter.isEnabled(), "The Twitter link is not enabled"),
            () -> Assertions.assertTrue(facebook.isDisplayed(), "The Facebook link is not displayed"),
            () -> Assertions.assertTrue(facebook.isEnabled(), "The Facebook link is not enabled"),
            () -> Assertions.assertTrue(linkedin.isDisplayed(), "The LinkedIn link is not displayed"),
            () -> Assertions.assertTrue(linkedin.isEnabled(), "The LinkedIn link is not enabled"),
            () -> Assertions.assertTrue(copyright.isDisplayed(), "The copyright text is not displayed")
        );
    }

    @Then("verify that the URL for {string} is {string}")
    public void verifyLinks(String socialNetwork, String url) {
        test.info("Verify the URLs of social networks");
        
        WebElement link;
        if (socialNetwork.equals("Twitter")) {
            link = footer.getTwitter();
        } else if (socialNetwork.equals("Facebook")) {
            link = footer.getFacebook();
        } else {
            link = footer.getLinkedin();
        }

        Assertions.assertEquals(url, link.getDomAttribute("href"), "The URL for " + socialNetwork + " is not correct");
    }
}
