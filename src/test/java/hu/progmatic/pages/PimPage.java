package hu.progmatic.pages;

import hu.progmatic.report.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PimPage {
    WebDriver driver;
    WebDriverWait wait;

    Reporting reporting;
    String newEmployeeId = "1527";
    String getNewEmployeeIdLocator = "'"+newEmployeeId+"'";


    By pimButtonBy = By.xpath("//span[text()='PIM']");
    By addButtonBy = By.xpath("//button[text()=' Add ']");
    By firstNameBy = By.cssSelector("input[name='firstName']");
    By lastNameBy = By.cssSelector("input[name='lastName']");
    By employeeIdBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    By searchEmployeeIdBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    By saveButtonBy = By.cssSelector("button[type='submit']");
    By employeeListButtonBy = By.xpath("//a[text()='Employee List']");

    By searchButtonBy = By.xpath("//button[text()=' Search ']");

    By foundEmployeeIdBy = By.xpath("//div[text()="+getNewEmployeeIdLocator+"]");

    public PimPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickOnPIMButton() {
        WebElement pimButton = driver.findElement(pimButtonBy);
        pimButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("PIM button clicked");
    }

    public void clickOnAddButton() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("add button clicked");
    }

    public void addNewEmployeeData() throws InterruptedException {
        WebElement firstName = driver.findElement(firstNameBy);
        firstName.sendKeys("Piramis");
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Piramis is written in Firstname field");
        WebElement lastName = driver.findElement(lastNameBy);
        lastName.sendKeys("Ferenc");
        reporting.sendDateAndReportMessage("Ferenc is written in Lastname field");
        WebElement employeeId = driver.findElement(employeeIdBy);
        employeeId.click();
        employeeId.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        reporting.sendDateAndReportMessage("Employee Id input field cleared");
        employeeId.sendKeys(newEmployeeId);
        reporting.sendDateAndReportMessage(newEmployeeId+" is written in Employee id field");
    }

    public void clickOnSaveButton(){
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Save button clicked");

    }

    public void clickOnEmployeeList(){
        WebElement employeeListButton = driver.findElement(employeeListButtonBy);
        employeeListButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("EmployeeList button clicked");
    }

    public void addEmployeeId(){
        WebElement searchEmployeeId = driver.findElement(searchEmployeeIdBy);
        searchEmployeeId.sendKeys(newEmployeeId);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage(newEmployeeId+" is written in EmployeeList input field");
    }

    public void clickOnSearchButton(){
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Search button clicked");
    }

    public void checkExistenceOfNewEmployeeInSystem(){
        WebElement foundEmployeeId = driver.findElement(foundEmployeeIdBy);
        Assert.assertEquals(foundEmployeeId.getText(), newEmployeeId);
        reporting = new Reporting();
        reporting.sendDateAndReportMessage(newEmployeeId+"is found in the system");
    }
}
