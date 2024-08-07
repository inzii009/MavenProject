package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class AddNewEmployeePage extends CommonMethods {
    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "middleName")
    public WebElement middleName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "employeeId")
    public WebElement employeeId;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id= "user_name")
    public WebElement createUsername;

    @FindBy(id = "user_password")
    public WebElement createPassword;

    @FindBy(id = "re_password")
    public WebElement confirmPassword;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@value='Edit']")
    public WebElement editButton;

    @FindBy(id="personal_cmbMarital")
    public WebElement martialStatusDropdown;

    @FindBy(id="personal_cmbNation")
    public WebElement nationalityDropdown;

    public AddNewEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
