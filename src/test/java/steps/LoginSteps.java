package steps;

import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication();//since method is static we can directly call it from CommonMethods
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
       // LoginPage loginPage=new LoginPage();
       // WebElement username=driver.findElement(By.id("txtUsername"));
        //loginPage.usernameField.sendKeys(ConfigReader.getPropertyValue("username"));//we are passing values from config.properties file instead of passing hardcoded data.
        sendText(loginPage.usernameField,ConfigReader.getPropertyValue("username"));
        //WebElement password=driver.findElement(By.id("txtPassword"));
        //loginPage.passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(loginPage.passwordField,ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //LoginPage loginPage=new LoginPage();
        //WebElement loginButton=driver.findElement(By.id("btnLogin"));
        //loginPage.loginBtnField.click();
        click(loginPage.loginBtnField);
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

    @When("user enters different {string} and {string} and verify the {string} for all the combinations")
    public void user_enters_different_and_and_verify_the_for_all_the_combinations(String usernameValue, String passwordValue, String error) {

        //LoginPage loginPage=new LoginPage();
        //WebElement username=driver.findElement(By.id("txtUsername"));
       //loginPage.usernameField.sendKeys(usernameValue);
        sendText(loginPage.usernameField,usernameValue);
       // WebElement password=driver.findElement(By.id("txtPassword"));
       // loginPage.passwordField.sendKeys(passwordValue);
        sendText(loginPage.passwordField,passwordValue);
        //WebElement loginButton=driver.findElement(By.id("btnLogin"));
        //loginPage.loginBtnField.click();
        click(loginPage.loginBtnField);


       // WebElement errorMessage=driver.findElement(By.id("spanMessage"));
        String errorActual=loginPage.errorMessageField.getText();
        Assert.assertEquals("Values do not match", error, errorActual);//comparing two values together
    }

    @Given("user enters different {string} and {string}")
    public void user_enters_different_and(String usernameValue, String passwordValue) {
       //LoginPage loginPage=new LoginPage();
      //WebElement username=driver.findElement(By.id("txtUsername"));
      //loginPage.usernameField.sendKeys(usernameValue);

        sendText(loginPage.usernameField,usernameValue); //this line will clear the text if present,locate element and pass the data

        //WebElement password=driver.findElement(By.id("txtPassword"));
        //loginPage.passwordField.sendKeys(passwordValue);

        sendText(loginPage.passwordField,passwordValue);
    }
    @Given("{string} user is successfully logged in")
    public void user_is_successfully_logged_in(String admin) {
        //DashboardPage dashboardPage=new DashboardPage();
       // WebElement dashBoardMessage=driver.findElement(By.id("welcome"));
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }
}
