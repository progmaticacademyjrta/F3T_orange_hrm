package hu.progmatic.pages;

import hu.progmatic.report.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;
    Reporting reporting;
    By adminButtonBy = By.xpath("//span[text()='Admin']");
    By addButtonBy = By.xpath("//button[text()=' Add ']");
    By userRoleInputBy = By.xpath("//div[text()='-- Select --']");
    By employeeNameInputBy = By.cssSelector("input[placeholder='Type for hints...']");
    By statusInputBy = By.xpath("//div[text()='-- Select --']");
    By userNameInputBy = By.cssSelector("input[autocomplete='off']");
    By passwordInputBy = By.cssSelector("input[type='password']");
    By saveButtonBy = By.cssSelector("button[type='submit']");
    By userBadgeBy = By.className("oxd-userdropdown-name");
    By logoutButtonBy = By.xpath("//a[text()='Logout']");
    By charachterNumberErrorButtonBy = By.xpath("//span[text()='Should be at least 5 characters']");

    public AdminPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToAdminPage() {
        WebElement adminButton = driver.findElement(adminButtonBy);
        adminButton.click();
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.isDisplayed();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("navigated to Admin Page");
    }

    public void clickAddButton() {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("navigated to Add User Page");
    }

    public void addNewUSerData(String userName, String password) throws InterruptedException {
        WebElement userRoleInput = driver.findElement(userRoleInputBy);
        userRoleInput.click();
        userRoleInput.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("ESS user role chosen");
        WebElement employeeNameInput = driver.findElement(employeeNameInputBy);
        employeeNameInput.click();
        employeeNameInput.sendKeys("Pa");
        Thread.sleep(2000); // a HTML kódban való megfoghatatlansága okán sajnos csak kivárni tudjuk a névlista megjelenését.
        employeeNameInput.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        reporting.sendDateAndReportMessage("Second Employee name chosen");
        WebElement statusInput = driver.findElement(statusInputBy);
        statusInput.click();
        statusInput.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        reporting.sendDateAndReportMessage("Disabled status chosen");
        WebElement userNameInput = driver.findElement(userNameInputBy);
        userNameInput.sendKeys(userName);
        reporting.sendDateAndReportMessage(userName + "written in username field");
        Thread.sleep(1000); // a hibaüzenet eltünését kell megvárni mivel az wait until invisible nem működött.
        List<WebElement> passwordInputFields = driver.findElements(passwordInputBy);
        for (WebElement passwordInput : passwordInputFields
        ) {
            passwordInput.sendKeys(password);

        }
        reporting.sendDateAndReportMessage(password+ " Written in both password field");
        reporting.sendDateAndReportMessage("Data filled");

    }

    public void clickSaveUser() {
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Data Saved");
        wait.until(ExpectedConditions.elementToBeClickable(addButtonBy));

    }
    public void logout() {
        WebElement userBadge = driver.findElement(userBadgeBy);
        userBadge.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("UserBadge clicked");
        WebElement logoutButton = driver.findElement(logoutButtonBy);
        logoutButton.click();
        reporting.sendDateAndReportMessage("loged out");
    }
}
