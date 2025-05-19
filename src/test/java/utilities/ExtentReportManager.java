package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import hooks.CucumberHooks;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("src/test/reports/ExtentReports.html");
            // Optional: Config
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Test Report");
            spark.config().setReportName("Swag Labs BDD Testing");
            spark.config().setTimeStampFormat("MMM-dd-yyyy HH:mm:ss");
            spark.config().setTimelineEnabled(true);
            
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Optional: System info
            extent.setSystemInfo("Framework", "Selenium with JUnit, Cucumber and ExtentReports");
            extent.setSystemInfo("Author", "Rafael Michelin");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Application URL", "https://www.saucedemo.com/");
            extent.setSystemInfo("Browser", CucumberHooks.browser.toUpperCase());
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }

    public static ExtentTest createTest(String name) {
        test = getInstance().createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}