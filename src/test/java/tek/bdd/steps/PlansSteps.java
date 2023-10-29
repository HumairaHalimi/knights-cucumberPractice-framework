package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.PlansPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;
import java.util.Map;

public class PlansSteps extends SeleniumUtility {

    @Then("Validate Section title is {string}")
    public void validateSectionTitle(String expectedSectionTitle) {
        String actualSectionTitle = getElementText(PlansPage.PLANS_SECTION_TITLE);
        Assert.assertEquals("Validate section title",
                expectedSectionTitle,
                actualSectionTitle);
    }

    @Then("Validate Table row is {int}")
    public void validateTableRowsCount(int expectedRows) {
        int actualRowSize = getListOfElements(PlansPage.TABLE_ROW_LOCATOR).size();
        Assert.assertEquals("validate table rows", expectedRows, actualRowSize);


    }

    @Then("Validate All Plans are Valid")
    public void validateAllPlansAreValid() {
        List<WebElement> elements = getListOfElements(PlansPage.PLAN_EXPIRED_COLUMN);
        for (WebElement element : elements) {
            String actualText = element.getText();
            Assert.assertEquals("validate all plans are valid", "Valid", actualText);
        }
    }

    @Then("Validate plan table header")
    public void validate_plan_table_header(DataTable dataTable) {
        // a data table as list
        // a data table as Map
        // a data table as List<Map>
      /*  List<Map<String, String>> tableMap = dataTable.asMaps();
        List<WebElement>headerElements= getListOfElements(PlansPage.PLAN_TABLE_HEADER_COLUMNS);
Map<String, String> expectedHeaders= tableMap.get(0); // like declaration of a variable
for (int i =0;i<headerElements.size(); i++){
   String actualHeader = headerElements.get(i).getText();
   String expectedHeader = expectedHeaders.get(String.valueOf(i));

    Assert.assertEquals("validate plan table header", expectedHeader,actualHeader);*/
        List<List<String>> tableList = dataTable.asLists();
        List<WebElement> headerElements = getListOfElements(PlansPage.PLAN_TABLE_HEADER_COLUMNS);
        List<String> expectedHeaders = tableList.get(0); // like declaration of a variable
        for (int i = 0; i < headerElements.size(); i++) {
            String actualHeader = headerElements.get(i).getText();
            String expectedHeader = expectedHeaders.get(i);

            Assert.assertEquals("validate plan table header", expectedHeader, actualHeader);
        }
    }

    @Then("Validate plan table data")
    public void validatePlanTableData(DataTable dataTable) {
        //in this example data table is without header and should
        // convert to list<list>
        List<List<String>> dataTableAsList = dataTable.asLists();
        System.out.println(dataTableAsList);//just to check how it looks like
        for (int row = 0; row < dataTableAsList.size(); row++) {
            List<String> rowData = dataTableAsList.get(row);
            System.out.println(row);
            System.out.println(rowData);
            // validate PlanType column
            String expectedPlanType = rowData.get(0); // first row
            String actualPlanType = getElementText(PlansPage.getTablePlanTypeColumn(row + 1));
            Assert.assertEquals("validate Table Plan Type", expectedPlanType, actualPlanType);
            // validate created by column
            String expectedCreatedBy = rowData.get(1);
            String actualCreatedBy = getElementText(PlansPage.getTableCreatedBy(row + 1));
            Assert.assertEquals("validate Table Created By", expectedCreatedBy, actualCreatedBy);
            //validate plan expired column
            String expectedPlanExpired = rowData.get(2);
            String actualPlanExpired = getElementText((PlansPage.getTablePlanExpiredColumn(row + 1)));

        }
     /*result in console
      0
     [Motorcycle, System, Valid]
     1
     [Boat, System, Valid]
     2
     [Renters, System, Valid]
     3
     [Auto, System, Valid]*/
    }

    @Then("Validate plan table data with maps")
    public void validatePlanTableDataWithMaps(DataTable dataTable) {
        //because data table is with headers
        List<Map<String, String>> dataTableAsMaps = dataTable.asMaps();
        //System.out.println(dataTableAsMaps);
        //because it is a map, so we can use the key to grab the value.
        for (int row = 0; row < dataTableAsMaps.size(); row++) {
            //get the data in each row
            Map<String, String> rowData = dataTableAsMaps.get(row);
            //validate "plan type" column
            String expectedPlanType = rowData.get("planType"); // we pass the key not a number
            String actualPlanType = getElementText(PlansPage.getTablePlanTypeColumn(row + 1));
            // we add one because xpath starts from one
            Assert.assertEquals("validate table plan type", expectedPlanType, actualPlanType);

            //validate "created By" column
            String expectedCreatedBy = rowData.get("createdBy");
            String actualCreatedBy = getElementText(PlansPage.getTableCreatedBy(row + 1));
            Assert.assertEquals("validate Created By", expectedCreatedBy, actualCreatedBy);
            // validate "isExpired"
            String expectedIsExpired = rowData.get("isExpired");
            String actualIsExpired = getElementText(PlansPage.getTablePlanExpiredColumn(row + 1));
            Assert.assertEquals("validate Isexpired column", expectedIsExpired, actualIsExpired);

        }
    }

    @Then("validate table header with single list")
    public void validateTableHeaderWithSingleList(DataTable dataTable) {
        List<String> expectedData = dataTable.asList();
        List<WebElement> columnsElements = getListOfElements((PlansPage.PLAN_TABLE_HEADER_COLUMNS));
        for (int index = 0; index < expectedData.size(); index++) {
            String expected = expectedData.get(index);
            String actual = columnsElements.get(index).getText();
            Assert.assertEquals("validate table headers", expected, actual);
        }

    }

    @Then("validate Plan Data first row only with single map")
    public void validate_plan_data_first_row_only_with_single_map(DataTable dataTable) {
        // single map with multiple key value pairs.
     Map<String, String> expectedData= dataTable.asMap();

    String expectedPlanType = expectedData.get("planType");
    String actualPlanType = getElementText(PlansPage.getTablePlanTypeColumn(1));
    Assert.assertEquals("validate Plan Type", expectedPlanType, actualPlanType);

        String expectedCreatedBy = expectedData.get("createdBy");
        String actualCreatedBy = getElementText(PlansPage.getTableCreatedBy(1));
        Assert.assertEquals("validate created by ", expectedCreatedBy, actualCreatedBy);

        String expectedIsExpired = expectedData.get("isExpired");
        String actualIsExpired = getElementText(PlansPage.getTablePlanExpiredColumn(1));
        Assert.assertEquals("validate is expired", expectedIsExpired, actualIsExpired);


    }
}
