package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.MyInfoPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyInfoPageTests extends DriverBaseTest {

@Test (description = "TC11")
    public void navigateToMyInfoTest() throws InterruptedException {
    LoginPage loginpage = new LoginPage(driver, wait);
    MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
    loginpage.loadLoginPage();
    loginpage.loginWithValidUserValidPass();
    myInfoPage.navigateToMyInfoPage();
}

@Test (description = "TC12")
    public void checkRequirementOfFirstNameTest() throws InterruptedException {
    LoginPage loginpage = new LoginPage(driver, wait);
    MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
    loginpage.loadLoginPage();
    loginpage.loginWithValidUserValidPass();
    myInfoPage.navigateToMyInfoPage();
    myInfoPage.checkRequirementOfFirstName();
    }

    @Test (description = "TC13")
    public void checkRequirementOfLastNameTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.checkRequirementOfLastName();
    }

    @Test (description = "TC14")
    public void checkIfFullNameHasBeenSavedTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.checkIfFullNameHasBeenSaved();
    }

    @Test (description = "TC18")
    public void navigateFromMyInfoToChangeProfilePicturePageTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.navigateFromMyInfoToChangeProfilePicturePage();
    }

    @Test(description = "TC19")
    public void licenseExpiryDateCheckTest () throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.licenseExpiryDateFieldCheck();
    }

    @Test(description = "TC20")
    public void chosenNationalityCheckTest () throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.chosenNationalityCheck();
    }
}
