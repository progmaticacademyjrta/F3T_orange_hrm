package hu.progmatic.pages;

import hu.progmatic.report.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage  {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    WebDriver driver;
    WebDriverWait wait;

    Reporting reporting;

    By usernameInputBy = By.cssSelector("input[name='username']");
    By passwordInputBy = By.cssSelector("input[name='password']");
    By loginButtonBy = By.cssSelector("button[type='submit']");
    By errorMessageEmptyInputBy = By.className("oxd-input-field-error-message");
    By errorMessageInvalidInputBy = By.className("oxd-alert-content-text");
    By loginTitleBy = By.className("orangehrm-login-title");
    By accountDisabledErrorBy = By.xpath("//p[text()='Account disabled']");

    //TC02
    public void loginWithValidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Admin is written in username field");
        reporting.sendDateAndReportMessage("password field left empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        System.out.println(alertMessage.getText());
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithValidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        UsernameInput.sendKeys("Admin");
        reporting.sendDateAndReportMessage("Admin is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        reporting.sendDateAndReportMessage("'a' is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithValidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        UsernameInput.sendKeys("Admin");
        reporting.sendDateAndReportMessage("Admin is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        reporting.sendDateAndReportMessage("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement adminButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        adminButton.isDisplayed();
        reporting.sendDateAndReportMessage("Login granted , Admin button visible");
    }

    public void loginWithInvalidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("'a' is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        reporting.sendDateAndReportMessage("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithInvalidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("'a' is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        reporting.sendDateAndReportMessage("'a' is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithEmptyUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("username field left empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        reporting.sendDateAndReportMessage("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithEmptyUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("username field left empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        reporting.sendDateAndReportMessage("'a' is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        alertMessage.isDisplayed();
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loginWithInvalidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        UsernameInput.sendKeys("a");
        reporting.sendDateAndReportMessage("'a' is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        reporting.sendDateAndReportMessage("password field field left empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        alertMessage.isDisplayed();
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }


    public void loginWithEmptyUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        reporting = new Reporting();
        UsernameInput.sendKeys("");
        reporting.sendDateAndReportMessage("username field left empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        reporting.sendDateAndReportMessage("password field field left empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        alertMessage.isDisplayed();
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");
    }

    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = driver.findElement(loginTitleBy);
        Assert.assertTrue(loginTitle.isDisplayed());
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Login Page loaded");
    }

    public void loginAddUser(String userName,String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys(userName);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage(userName + "written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys(password);
        reporting.sendDateAndReportMessage(password + "written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        reporting.sendDateAndReportMessage("Login button clicked");
        WebElement alertMessage = driver.findElement(accountDisabledErrorBy);
        alertMessage.isDisplayed();
        reporting.sendDateAndReportMessage("Login denied "+alertMessage.getText()+"is displayed");

    }


}