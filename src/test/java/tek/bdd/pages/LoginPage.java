package tek.bdd.pages;

import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class LoginPage extends SeleniumUtility {
    public final static By SECTION_TITLE = By.xpath
            ("/html/body/app-root/app-login/div/mat-card/mat-card-title[1]/strong");

   public final static By LOGIN_BUTTON = By.id("loginButton");
   public final static By USERNAME= By.name("username");

   public final static By PASSWORD= By.name("password");

   public final static By LOGGED_IN_USERNAME=By.xpath("//mat-toolbar/button[2]/span[1]");

public final static By ERROR_BANNER = By.cssSelector("app-banner>div.error");



}
