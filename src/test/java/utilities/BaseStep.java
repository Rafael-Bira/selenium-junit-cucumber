package utilities;

import com.aventstack.extentreports.ExtentTest;

public class BaseStep {
    protected ExtentTest test;

    protected BaseStep() {
        this.test = ExtentReportManager.getTest();
    }
}
