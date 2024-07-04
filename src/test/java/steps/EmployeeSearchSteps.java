package steps;

import Pages.AddNewEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
       // DashboardPage dashboardPage=new DashboardPage();
       //WebElement pimOption= driver.findElement(By.id("menu_pim_viewPimModule"));
       // dashboardPage.pimOption.click();
       // click(dashboardPage.pimOption);
        jsClick(dashboardPage.pimOption);
        //WebElement employeeListOption= driver.findElement(By.id("menu_pim_viewEmployeeList"));
       // dashboardPage.employeeListButton.click();
        click(dashboardPage.employeeListButton);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        //EmployeeListPage employeeListPage=new EmployeeListPage();
        //WebElement searchById= driver.findElement(By.id("empsearch_id"));
       // employeeListPage.employeeSearchById.sendKeys("45667");
        sendText(employeeListPage.employeeSearchById,"45667");
    }
    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //EmployeeListPage employeeListPage=new EmployeeListPage();
        //WebElement searchEmployeeName= driver.findElement(By.id("empsearch_employee_name_empName"));
        //employeeListPage.searchEmployeeByName.sendKeys("XYZT");
        sendText(employeeListPage.searchEmployeeByName,"XYTZ");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //EmployeeListPage employeeListPage=new EmployeeListPage();
        //WebElement searchButton= driver.findElement(By.id("searchBtn"));
        //employeeListPage.searchButton.click();
        click(employeeListPage.searchButton);
    }

    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Information is displayed on page");
    }

    @When("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
    loginPage.login(ConfigReader.getPropertyValue("username"),ConfigReader.getPropertyValue("password"));

    }
}
