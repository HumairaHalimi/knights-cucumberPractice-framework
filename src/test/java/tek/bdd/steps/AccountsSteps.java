package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountsPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class AccountsSteps extends SeleniumUtility {
    @Then("Validate accounts table have {int} rows")
    public void validateAccountsTableHasTenRows(int expectedRows) {

      List<WebElement> tableRowsElements =getListOfElements(AccountsPage.TABLE_ROWS);
      Assert.assertEquals("Validate Account Table rows", expectedRows, tableRowsElements.size());
    }

}
