package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {

    @Test(description = "TC01: Belépési oldal megnyitás")
    public void openOrangeHrmPageTest(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
    }

    @Test(description = "TC02: Főoldalra való belépés valid felhasználónévvel és valid jelszóval")
    public void loginWithValidUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserValidPass();
    }

    @Test(description = "TC03: Főoldalra való belépés valid felhasználónévvel és invalid jelszóval")
    public void loginWithValidUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserInvalidPass();
    }

    @Test(description = "TC04: Főoldalra való belépés invalid felhasználónévvel és valid jelszóval")
    public void loginWithInvalidUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserValidPass();
    }

    @Test(description = "TC05: Főoldalra való belépés invalid felhasználónévvel és invalid jelszóval")
    public void loginWithInvalidUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserInvalidPass();
    }

    @Test(description = "TC06: Főoldalra való belépés üres felhasználónév mezővel és valid jelszóval")
    public void loginWithEmptyUserValidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserValidPass();
    }

    @Test(description = "TC07: Főoldalra való belépés valid felhasználónévvel és üres jelszó mezővel")
    public void loginWithValidUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithValidUserEmptyPass();
    }

    @Test(description = "TC08: Főoldalra való belépés üres felhasználónév mezővel és invalid jelszóval")
    public void loginWithEmptyUserInvalidPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserInvalidPass();
    }

    @Test(description = "TC09: Főoldalra való belépés invalid felhasználónévvel és üres jelszó mezővel")
    public void loginWithInvalidUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithInvalidUserEmptyPass();
    }

    @Test(description = "TC10: Főoldalra való belépés üres felhasználónév mezővel és üres jelszó mezővel")
    public void loginWithEmptyUserEmptyPassTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.loginWithEmptyUserEmptyPass();
    }

}





