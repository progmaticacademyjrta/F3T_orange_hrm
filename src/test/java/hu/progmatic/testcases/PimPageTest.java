package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.PimPage;
import org.testng.annotations.Test;

public class PimPageTest extends DriverBaseTest {
    String employeeId = "1526";
    @Test (description = "TC22")
    public void addingNewUserInPimMenu() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        PimPage pimpage = new PimPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        pimpage.clickOnPIMButton();
        pimpage.clickOnAddButton();
        pimpage.addNewEmployeeData();
        pimpage.clickOnSaveButton();
        pimpage.clickOnEmployeeList();
        pimpage.addEmployeeId();
        pimpage.clickOnSearchButton();
        Thread.sleep(3000);
        pimpage.checkExistenceOfNewEmployeeInSystem();
        System.out.println("Test done!");
    }
}
