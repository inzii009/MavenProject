package steps;

import Pages.DashboardPage;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("verify all the dashboard tabs")
    public void verify_all_the_dashboard_tabs(DataTable dataTable) {
        //DashboardPage dashboardPage=new DashboardPage();
        //we didn't provide keys in feature file so, we don't use Map ,but use List only.

        // Get expected tabs from DataTable
        List<String> expectedTabs = dataTable.asList();

       // Get actual tabs from the application
        //List<WebElement> dashboardTabs = driver.findElements(By.xpath("//div[@class='menu']/ul/li"));

        List<String> actualTabs = new ArrayList<>();

        for (WebElement tab : dashboardPage.dashboardTabs) {
            // Normalize whitespace: replace any sequence of whitespace characters with a single space, and trim the text
            String tabText=tab.getText();
            String[] splitTab=tabText.split("\n");
            actualTabs.addAll(Arrays.asList(splitTab));
        }

       // Print expected and actual tabs for debugging
        System.out.println("Expected Tabs: " + expectedTabs);
        System.out.println("Actual tabs"+ actualTabs);

        // Assert that the expected tabs match the actual tabs
        Assert.assertEquals(expectedTabs, actualTabs);
        }
}
