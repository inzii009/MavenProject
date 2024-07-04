package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class EmployeeListPage extends CommonMethods {

    @FindBy(id="empsearch_id")
    public WebElement employeeSearchById;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement searchEmployeeByName;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }
}
