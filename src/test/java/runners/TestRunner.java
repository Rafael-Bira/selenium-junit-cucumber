package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps", "hooks"}
    ,plugin = {"pretty"}
    // ,name = {"Click the Continue button without filling any input"}
    // ,tags = "@confirmation"
)

public class TestRunner {}