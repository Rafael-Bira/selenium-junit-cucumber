package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver useDriver() {
        new DriverProvider();
        return DriverProvider.get();
    } 

    protected WebElement find(By locator) {
        return useDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return useDriver().findElements(locator);
    }
}
