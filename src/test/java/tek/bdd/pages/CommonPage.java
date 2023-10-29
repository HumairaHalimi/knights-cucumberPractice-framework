package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class CommonPage extends SeleniumUtility {
    public final static By PAGE_TITLE = By. xpath("//mat-toolbar/span[1]");

  // static method that returns By Object
    public static By getLinkLocator(String linkText)
    {
        return By.partialLinkText(linkText);

    }

}
