package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {

    @Test
    public void loginWithValidUerValidPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loadLoginPage();
        loginPage.LoginWithValidUserValidPass();
    }
    }





