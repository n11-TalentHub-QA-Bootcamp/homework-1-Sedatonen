package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps",
        tags = "@votes",
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html"},
        dryRun = false
)

public class CukesRunner {

}