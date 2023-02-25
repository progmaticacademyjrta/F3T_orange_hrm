package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }



    By usernameInputBy = By.cssSelector("input[name='username']");
    By passwordInputBy = By.cssSelector("input[name='password']");
    By loginButtonBy = By.cssSelector("button[type='submit']");
    By errorMessageEmptyInputBy = By.className("oxd-input-field-error-message");
    By errorMessageInvalidInputBy = By.className("oxd-alert-content-text");
    By loginTitleBy = By.className("orangehrm-login-title");
    By accountDisabledErrorBy = By.xpath("//p[text()='Account disabled']");



    public void LoginWithValidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        System.out.println(alertMessage.getText());
    }

    public void LoginWithValidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());
    }

    public void LoginWithValidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement adminButton = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminButton.isDisplayed();
        Thread.sleep(2000);
    }
    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = driver.findElement(loginTitleBy);
        Assert.assertTrue(loginTitle.isDisplayed());

    }
    public void LoginAddUser(String userName,String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys(userName);
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement accountDisabledError = driver.findElement(accountDisabledErrorBy);
        accountDisabledError.isDisplayed();
}}
