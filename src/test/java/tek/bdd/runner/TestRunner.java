package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "tek.bdd.steps",
        tags = " ",
        dryRun =false, //if true wont run steps just check for un implemented stages
        plugin = {
                "html:target/html_report/report.html"
}
        )
public class TestRunner {
}
