package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {

    @Test(description = "TC01")
    public void openOrangeHrmPageTest(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
    }

    @Test(description = "TC02")
    public void loginWithValidUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserValidPass();
    }

    @Test(description = "TC03")
    public void loginWithValidUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserInvalidPass();
    }

    @Test(description = "TC04")
    public void loginWithInvalidUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserValidPass();

    }

    @Test(description = "TC05")
    public void loginWithInvalidUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserInvalidPass();
    }

    @Test(description = "TC06")
    public void loginWithEmptyUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserValidPass();
    }

    @Test(description = "TC07")
    public void loginWithValidUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserEmptyPass();
    }

    @Test(description = "TC08")
    public void loginWithEmptyUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserInvalidPass();
    }

    @Test(description = "TC09")
    public void loginWithInvalidUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserEmptyPass();
    }

    @Test(description = "TC10")
    public void loginWithEmptyUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserEmptyPass();
    }





}












