package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication(); //since method is static we can directly call it from CommonMethods
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        WebElement username=driver.findElement(By.id("txtUsername"));
        username.sendKeys(ConfigReader.getPropertyValue("username"));//we are passing from config.properties file instead of passing hardcoded data.
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys(ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        System.out.println("Test passed");
    }

    @Then("user close the browser")
    public void user_close_the_browser() {
       closeBrowser();
    }
    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
