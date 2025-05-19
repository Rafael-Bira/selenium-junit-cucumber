package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class Footer extends BasePage {
    // Locators
    private final By twitterLink = By.cssSelector("[data-test='social-twitter']");
    private final By facebookLink = By.cssSelector("[data-test='social-facebook']");
    private final By linkedinLink = By.cssSelector("[data-test='social-linkedin']");
    private final By copyright = By.cssSelector("[data-test='footer-copy']");

    // Getters
    public WebElement getTwitter() {
        return find(twitterLink);
    }

    public WebElement getFacebook() {
        return find(facebookLink);
    }

    public WebElement getLinkedin() {
        return find(linkedinLink);
    }
    
    public WebElement getCopyright() {
        return find(copyright);
    }
}
