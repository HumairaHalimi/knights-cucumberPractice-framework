package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofMinutes(1));
    }

    private WebElement waitUntilVisibilityOfElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> waitUntilVisibilityOfAllElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    private WebElement waitUntilElementClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickOnElement(By locator) {
        waitUntilElementClickable(locator).click();

    }


    public String getElementText(By locator) {

        WebElement element = waitUntilVisibilityOfElement(locator);
        return element.getText();
    }

    public boolean isElementEnabled(By locator) {

        WebElement element = waitUntilVisibilityOfElement(locator);
        return element.isEnabled();

    }

    public void enterValue(By locator, String text) {

        WebElement element = waitUntilVisibilityOfElement(locator);
        element.sendKeys(text);
    }

    public List<WebElement> getListOfElements(By locator) {
        List<WebElement> elements = waitUntilVisibilityOfAllElement(locator);
        return elements;
    }

    public byte[] takeScreenShoot()
    {

            TakesScreenshot screenShot = (TakesScreenshot) getDriver();
            return screenShot.getScreenshotAs(OutputType.BYTES);

        }
    }





