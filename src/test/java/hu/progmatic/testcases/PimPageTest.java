package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimPageTest extends DriverBaseTest {
    String employeeId = "1234567812";
    @Test (description = "TC22")
    public void addingNewUserInPimMenu() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        PimPage pimpage = new PimPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        pimpage.clickOnPIMButton();
        pimpage.clickOnAddButton();
        pimpage.addNewEmployeeData(employeeId);
        pimpage.clickOnSaveButton();
        pimpage.clickOnEmployeeList();
        pimpage.addEmployeeId(employeeId);
        pimpage.clickOnSearchButton();
        Thread.sleep(3000);
        pimpage.checkExistenceOfNewEmployeeInSystem(employeeId);
        System.out.println("Test done!");
    }
}
