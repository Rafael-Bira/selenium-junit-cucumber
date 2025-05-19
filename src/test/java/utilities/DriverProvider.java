package utilities;

import org.openqa.selenium.WebDriver;

public class DriverProvider {
    private static ThreadLocal<WebDriver> thread = new ThreadLocal<>();

    public static void set(WebDriver driver) {
        thread.set(driver);
    }

    public static WebDriver get() {
        return thread.get();
    }
}
