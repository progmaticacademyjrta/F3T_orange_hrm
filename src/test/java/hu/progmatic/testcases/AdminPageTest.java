package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AdminPage;
import hu.progmatic.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AdminPageTest extends DriverBaseTest {
    String userName = "Paladin"; // minimum 5 karakter
    String password = "Pir@mis3"; // kisbetű, nagybetű , szám és speciális karakter kötelező
    LoginPage loginPage;
    AdminPage adminPage;
    @Test (description = "TC21")
    public void createNewUserInAdminTest() throws InterruptedException {
        loginPage = new LoginPage(driver,wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserValidPass();
        adminPage = new AdminPage(driver,wait);
        adminPage.goToAdminPage();
        adminPage.clickAddButton();
        adminPage.addNewUSerData(userName,password);
        adminPage.clickSaveUser();
        adminPage.logout();
        loginPage.loginAddUser(userName,password);
    }
}
