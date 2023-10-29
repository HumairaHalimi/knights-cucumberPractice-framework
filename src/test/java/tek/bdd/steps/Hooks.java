package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtility;

public class Hooks extends SeleniumUtility {
    @Before
    public void setUpTests() {
        openBrowser();
    }


    @After

    public void cleanUpTests(Scenario scenario) {
        if (scenario.isFailed()) {
            //TakesScreenshot screenShot = (TakesScreenshot) getDriver();
           // byte[] picture = screenShot.getScreenshotAs(OutputType.BYTES);
           // scenario.attach(picture, "image/png", "failedScreenShot"); //moved to seleniumUtility

            byte[] picture=takeScreenShoot();
            scenario.attach(picture, "image/png", "failedScreenShot");

        }

        driverQuit();
    }

}