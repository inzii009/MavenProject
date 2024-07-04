package steps;

import Pages.AddNewEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeListPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //DashboardPage dashboardPage=new DashboardPage();
        //WebElement pimOption= driver.findElement(By.id("menu_pim_viewPimModule"));
        //dashboardPage.pimOption.click();
        click(dashboardPage.pimOption);
    }
    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        //DashboardPage dashboardPage=new DashboardPage();
       //WebElement addEmployeeOption= driver.findElement(By.id("menu_pim_addEmployee"));
        //dashboardPage.addEmployeeButton.click();
        click(dashboardPage.addEmployeeButton);
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();
        //WebElement userName= driver.findElement(By.id("firstName"));
        //addNewEmployeePage.firstName.sendKeys("Banter");
        sendText(addNewEmployeePage.firstName,"Banter");
        //WebElement lastName= driver.findElement(By.id("lastName"));
        //addNewEmployeePage.lastName.sendKeys("Bubbles");
        sendText(addNewEmployeePage.lastName,"Bubbles");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();
        //WebElement saveButton= driver.findElement(By.id("btnSave"));
       // addNewEmployeePage.saveButton.click();
        click(addNewEmployeePage.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }
    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {//keys coming from my feature file and passing below
        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();
        //WebElement userNameLoc= driver.findElement(By.id("firstName"));
        //addNewEmployeePage.firstName.sendKeys(firstName);
        sendText(addNewEmployeePage.firstName,firstName);
        //WebElement middleNameLoc= driver.findElement(By.id("middleName"));
        //addNewEmployeePage.middleName.sendKeys(middleName);
        sendText(addNewEmployeePage.middleName,middleName);
        //WebElement lastNameLoc= driver.findElement(By.id("lastName"));
        //addNewEmployeePage.lastName.sendKeys(lastName);
        sendText(addNewEmployeePage.lastName,lastName);
    }

    @When("user enters direct data {string} {string} and {string}")
    public void user_enters_direct_data_and(String firstName, String middleName, String lastName) {
        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();
        //WebElement userNameLoc= driver.findElement(By.id("firstName"));
        //addNewEmployeePage.firstName.sendKeys(firstName);
        sendText(addNewEmployeePage.firstName,firstName);
        //WebElement middleNameLoc= driver.findElement(By.id("middleName"));
       // addNewEmployeePage.middleName.sendKeys(middleName);
        sendText(addNewEmployeePage.middleName,middleName);
        //WebElement lastNameLoc= driver.findElement(By.id("lastName"));
        //addNewEmployeePage.lastName.sendKeys(lastName);
        sendText(addNewEmployeePage.lastName,lastName);
    }

    @When("user add multiple employees and verify they are added")
    public void user_add_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {//dataTable is object from feature file to call DataTable
    List<Map<String,String>> employeeNames =dataTable.asMaps();// taking all data as Map(keys and values) and storing the in List of Maps

        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();

        for (Map<String,String> emp:employeeNames){ //every row in feature file returns one Map(keys and values)
            String firstNameValue=emp.get("firstName");//passing the key and getting its value by storing
            String middleNameValue=emp.get("middleName");
            String lastNameValue=emp.get("lastName");

            //to add multiple employees we place in loop.
            //taking values from above we pass them here after locating WebElement
            //WebElement userNameLoc= driver.findElement(By.id("firstName"));
            //addNewEmployeePage.firstName.sendKeys(firstNameValue);
            sendText(addNewEmployeePage.firstName,firstNameValue);
            //WebElement middleNameLoc= driver.findElement(By.id("middleName"));
            //addNewEmployeePage.middleName.sendKeys(middleNameValue);
            sendText(addNewEmployeePage.middleName,middleNameValue);
            //WebElement lastNameLoc= driver.findElement(By.id("lastName"));
            //addNewEmployeePage.lastName.sendKeys(lastNameValue);
            sendText(addNewEmployeePage.lastName,lastNameValue);
            //WebElement saveButton= driver.findElement(By.id("btnSave"));
            //addNewEmployeePage.saveButton.click();
            click(addNewEmployeePage.saveButton);

            Thread.sleep(5000);
            //to come back again to add another employee,so that hooks and background works for one time
            //DashboardPage dashboardPage=new DashboardPage();
            //WebElement addEmployeeOption= driver.findElement(By.id("menu_pim_addEmployee"));
            //dashboardPage.addEmployeeButton.click();
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(3000);
        }
    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employees")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employees(String sheetName) throws InterruptedException {
        /*This line reads data from an Excel file into a list of maps,
         sheetName from feature file*/
        List<Map<String,String>> newEmployees = ExcelReading.excelIntoListMap
                                                        (Constants.EXCEL_File_PATH,sheetName);
        //AddNewEmployeePage addNewEmployeePage=new AddNewEmployeePage();

        //An iterator is used to loop through the list of employees.
        Iterator<Map<String,String>> iterator= newEmployees.iterator();
        
        //checks for element and returns true until we have an element.
        while (iterator.hasNext()){
            //it returns key and value for new employees
            Map<String,String> mapNewEmp=iterator.next();

            //WebElement userNameLoc= driver.findElement(By.id("firstName"));
            addNewEmployeePage.firstName.sendKeys(mapNewEmp.get("FirstName")); //value from Excel file
            //WebElement middleNameLoc= driver.findElement(By.id("middleName"));
            addNewEmployeePage.middleName.sendKeys(mapNewEmp.get("MiddleName"));
            //WebElement lastNameLoc= driver.findElement(By.id("lastName"));
            addNewEmployeePage.lastName.sendKeys(mapNewEmp.get("LastName"));
            //to capture employee id while creating it.
            //WebElement epmId= driver.findElement(By.id("employeeId"));
            String empIdValue=addNewEmployeePage.employeeId.getAttribute("value");

            //WebElement photo= driver.findElement(By.id("photofile"));
            addNewEmployeePage.photograph.sendKeys(mapNewEmp.get("Photograph"));

           // WebElement checkBox= driver.findElement(By.id("chkLogin"));
            if (!addNewEmployeePage.checkBox.isSelected()){
               // addNewEmployeePage.checkBox.click();
                click(addNewEmployeePage.checkBox);
            }

           // WebElement username= driver.findElement(By.id("user_name"));
           // addNewEmployeePage.createUsername.sendKeys(mapNewEmp.get("Username"));
            sendText(addNewEmployeePage.createUsername,mapNewEmp.get("Username"));
            //WebElement password= driver.findElement(By.id("user_password"));
            //addNewEmployeePage.createPassword.sendKeys(mapNewEmp.get("Password"));
            sendText(addNewEmployeePage.createPassword,mapNewEmp.get("Password"));
            //WebElement confirmPassword= driver.findElement(By.id("re_password"));
            //addNewEmployeePage.confirmPassword.sendKeys(mapNewEmp.get("Password"));
            sendText(addNewEmployeePage.confirmPassword,mapNewEmp.get("Password"));
            //WebElement saveButton= driver.findElement(By.id("btnSave"));
            //addNewEmployeePage.saveButton.click();
            click(addNewEmployeePage.saveButton);


            Thread.sleep(5000);

            //search id in employee list for Verifying Employee Addition

            //DashboardPage dashboardPage=new DashboardPage();
            //WebElement empList= driver.findElement(By.id("menu_pim_viewEmployeeList"));
            //dashboardPage.employeeListButton.click();
            click(dashboardPage.employeeListButton);

            Thread.sleep(1000);
            //EmployeeListPage employeeListPage=new EmployeeListPage();
            //WebElement empIdSearchField= driver.findElement(By.id("empsearch_id"));
            //employeeListPage.employeeSearchById.sendKeys(empIdValue);
            sendText(employeeListPage.employeeSearchById,empIdValue);
            System.out.println(empIdValue);
            //WebElement searchButton= driver.findElement(By.id("searchBtn"));
            //employeeListPage.searchButton.click();
            click(employeeListPage.searchButton);

            //getting all data in List
            List<WebElement> rowData=driver.findElements
                    (By.xpath("//table[@id='resultTable']/tbody/tr"));

            //for loop
            for (int i = 0; i < rowData.size(); i++) {
                System.out.println("I'm in inside my loop");
                String rowText=rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData=empIdValue +" "+ mapNewEmp.get("FirstName") +" "+ mapNewEmp.get("MiddleName")
                         +" "+ mapNewEmp.get("LastName"); //from Excel file
                System.out.println(expectedData);

                Assert.assertEquals(expectedData,rowText);

            }

            //to come back again to add another employee,so that hooks and background works for one time
            //WebElement addEmployeeOption= driver.findElement(By.id("menu_pim_addEmployee"));
            //dashboardPage.addEmployeeButton.click();
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(3000);


        }

    }

}
