package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseSetup {
    private static WebDriver driver;// it must be static to share to all other classes
    // and objects inside the project and be private because we don't want others to have
    //access to change it. But to have access to read it we have getter method in this class..
    private final String url = "https://qa.insurance.tekschool-students.com/";
    private final String BROWSER_TYPE = "chrome";

    public void openBrowser()
    {

        //recording76), using other browsers too.
        if(BROWSER_TYPE.equalsIgnoreCase("chrome")) {
            //Add headless option to Chrome browser
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver = new ChromeDriver();
        }else if (BROWSER_TYPE.equalsIgnoreCase("fireFox")){
            driver=new FirefoxDriver();
        }else if(BROWSER_TYPE.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else{
            throw new RuntimeException("wrong browser type");
        }
        //targeting chrome for now
        //creating instance of browser
        //and navigate for insurance app
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }
    public void driverQuit()
    {
        if(driver != null)// there is a possibility for driver to be null, that
            // is why we add this if condition
            driver.quit();
    }
    public WebDriver getDriver()
    {

        return driver;
    }

}
