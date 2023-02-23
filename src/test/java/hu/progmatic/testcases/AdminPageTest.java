package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AdminPage;
import hu.progmatic.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AdminPageTest extends DriverBaseTest {
    String userName = "Paladin3";
    String password = "Pir@mis3";
    LoginPage loginPage;
    AdminPage adminPage;
    @Test
    public void createNewUserInAdminTest() throws InterruptedException {
        loginPage = new LoginPage(driver,wait);
        loginPage.loadLoginPage();
        loginPage.LoginWithValidUserValidPass();
        adminPage = new AdminPage(driver,wait);
        adminPage.goToAdminPage();
        adminPage.clickAddButton();
        adminPage.addNewUSerData(userName,password);
        adminPage.clickSaveUser();
        Thread.sleep(3000);
        adminPage.logout();
        loginPage.LoginAddUser(userName,password);
    }
}
