package steps;

import Pages.AddNewEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeListPage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeListPage employeeListPage;
    public static AddNewEmployeePage addNewEmployeePage;


    public static void initializePageObjects(){
        loginPage =new LoginPage();
        dashboardPage =new DashboardPage();
        employeeListPage =new EmployeeListPage();
        addNewEmployeePage =new AddNewEmployeePage();

    }
}
