package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.MyInfoPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyInfoPageTests extends DriverBaseTest {

@Test (description = "TC11: Navigate to My Info Page")
    public void navigateToMyInfoTest() throws InterruptedException {
    LoginPage loginpage = new LoginPage(driver, wait);
    MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
    loginpage.loadLoginPage();
    loginpage.loginWithValidUserValidPass();
    myInfoPage.navigateToMyInfoPage();
}

@Test (description = "TC12: Test to check the requirement of First Name field in My Info Menu")
    public void checkRequirementOfFirstNameTest() throws InterruptedException {
    LoginPage loginpage = new LoginPage(driver, wait);
    MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
    loginpage.loadLoginPage();
    loginpage.loginWithValidUserValidPass();
    myInfoPage.navigateToMyInfoPage();
    myInfoPage.checkRequirementOfFirstName();
    }

    @Test (description = "TC13: Test to check the requirement of Last Name field in My Info Menu")
    public void checkRequirementOfLastNameTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.checkRequirementOfLastName();
    }

    @Test (description = "TC14: Personal Details Employee Full Name saving and checking if it has been saved")
    public void checkIfFullNameHasBeenSavedTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.checkIfFullNameHasBeenSaved();
    }

    @Test (description = "TC18: Navigate form My Info Page to Change Profile Picture Page via clicking the photo")
    public void navigateFromMyInfoToChangeProfilePicturePageTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.navigateFromMyInfoToChangeProfilePicturePage();
    }

    @Test(description = "TC19: Check if wrong date input alerts with error message")
    public void licenseExpiryDateCheckTest () throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.licenseExpiryDateFieldCheck();
    }

    @Test(description = "TC20: Check the chosen nationality")
    public void chosenNationalityCheckTest () throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver, wait);
        MyInfoPage myInfoPage = new MyInfoPage(driver, wait);
        loginpage.loadLoginPage();
        loginpage.loginWithValidUserValidPass();
        myInfoPage.navigateToMyInfoPage();
        myInfoPage.chosenNationalityCheck();
    }
}
