package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverProvider;
import utilities.ExtentReportManager;

public class CucumberHooks {
    private static WebDriver driver;   
    private static int scenarioCount;

    // --> Choose browser: Firefox, Edge (Chrome by default if empty)
    public final static String browser = "edge";
    // --> Choose headless mode (false by default)
    private final boolean headless = true;

    @Before
    public void beforeScenario(Scenario scenario) {
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                break;           
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                // Disable password manager
                chromeOptions.addArguments("--disable-infobars");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new DriverProvider();
        DriverProvider.set(driver);

        // Create report logs for each scenario
        scenarioCount++;
        ExtentTest test = ExtentReportManager.createTest(scenario.getName());
        test.info("SCENARIO " + scenarioCount + " - " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        ExtentTest test = ExtentReportManager.getTest();        
        if (scenario.isFailed()) {
            // Take a screenshot and save it in the reports/screenshots folder
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            String screenshotName = scenario.getName() + "_" + timestamp + ".png";
            String dest = "src/test/reports/screenshots/" + screenshotName;
            File destination = new File(dest);
            try {
                Files.createDirectories(destination.getParentFile().toPath());
                Files.copy(src.toPath(), destination.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            test.fail("STEP FAILED! -> <em>" + screenshotName + "</em>");
        } 
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest test = ExtentReportManager.getTest();        
        if (scenario.isFailed()) {
            test.fail("SCENARIO FAILED!");
        } else {
            test.pass("Scenario passed");
        }
        ExtentReportManager.getInstance().flush();

        // Quit driver
        driver.quit();
    }
}