package hu.progmatic.pages;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LoginPage {

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

    //TC02
    public void loginWithValidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage = driver.findElement(errorMessageEmptyInputBy);
        System.out.println(alertMessage.getText());
    }

    public void loginWithValidUserInvalidPass() throws InterruptedException {
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

    public void loginWithValidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("Admin");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement adminButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span"));
        adminButton.isDisplayed();
    }

    public void loginWithInvalidUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());

    }

    public void loginWithInvalidUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage = driver.findElement(errorMessageInvalidInputBy);
        System.out.println(alertMessage.getText());
    }

    public void loginWithEmptyUserValidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
    }

    public void loginWithEmptyUserInvalidPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("a");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
    }

    public void loginWithInvalidUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("a");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
    }


    public void loginWithEmptyUserEmptyPass() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement UsernameInput = driver.findElement(usernameInputBy);
        UsernameInput.sendKeys("");
        WebElement PasswordInput = driver.findElement(passwordInputBy);
        PasswordInput.sendKeys("");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
        WebElement errorMessage = driver.findElement(errorMessageEmptyInputBy);
        errorMessage.isDisplayed();
    }
    //TC01
    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = driver.findElement(loginTitleBy);
        Assert.assertTrue(loginTitle.isDisplayed());

    }
}
