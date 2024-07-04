package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.ConfigReader;


public class LoginPage extends CommonMethods {
    @FindBy   (id="txtUsername")
    public WebElement usernameField;

    @FindBy     (id="txtPassword")
    public WebElement passwordField;

    @FindBy     (id="btnLogin")
    public WebElement loginBtnField;

    @FindBy     (id="spanMessage")
    public WebElement errorMessageField;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username,String password){
          //usernameField.sendKeys(username);
          //passwordField.sendKeys(password);
          sendText(usernameField, ConfigReader.getPropertyValue("username"));
          sendText(passwordField,ConfigReader.getPropertyValue("password"));
          //loginBtnField.click();
          click(loginBtnField);
   }

}
