package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage  {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    WebDriver driver;
    WebDriverWait wait;

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
        Reporter.log("Admin is written in password field");
        Reporter.log("password field field letf empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        System.out.println(alertMessage.getText());
        Reporter.log("Login denied ,Required error message is displayed");
    }

    public void loginWithValidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        Reporter.log("Admin is written in password field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        Reporter.log("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());
        Reporter.log("Login denied , Invalid credentials message visible");
    }

    public void loginWithValidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        Reporter.log("Admin is written in password field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        Reporter.log("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement adminButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        adminButton.isDisplayed();
        Reporter.log("Login granted , Admin button visible");
    }

    public void loginWithInvalidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        Reporter.log("a is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        Reporter.log("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());
        Reporter.log("Login denied , Invalid credentials message visible");

    }

    public void loginWithInvalidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        Reporter.log("a is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        Reporter.log("a is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());
        Reporter.log("Login denied , Invalid credentials message visible");
    }

    public void loginWithEmptyUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        Reporter.log("username field letf empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        Reporter.log("admin123 is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
        Reporter.log("Login denied ,Required error message is displayed");
    }

    public void loginWithEmptyUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        Reporter.log("username field letf empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        Reporter.log("a is written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
        Reporter.log("Login denied ,Required error message is displayed");
    }

    public void loginWithInvalidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        Reporter.log("a is written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        Reporter.log("password field field letf empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
        Reporter.log("Login denied ,Required error message is displayed");
    }


    public void loginWithEmptyUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        Reporter.log("username field letf empty");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        Reporter.log("password field field letf empty");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
        Reporter.log("Login denied ,Required error message is displayed");
    }
    //TC01
    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = driver.findElement(loginTitleBy);
        Assert.assertTrue(loginTitle.isDisplayed());
        Reporter.log("Login Page loaded");

    }
    public void loginAddUser(String userName,String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys(userName);
        Reporter.log(userName + "written in username field");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys(password);
        Reporter.log(password + "written in password field");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Reporter.log("Login button clicked");
        WebElement accountDisabledError = driver.findElement(accountDisabledErrorBy);
        accountDisabledError.isDisplayed();
        Reporter.log("Login denied, Account Disabled message visible");

    }


}