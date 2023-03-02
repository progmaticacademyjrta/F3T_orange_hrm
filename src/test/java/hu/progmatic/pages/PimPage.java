package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class PimPage {
    WebDriver driver;
    WebDriverWait wait;


    By pimButtonBy = By.xpath("//span[text()='PIM']");
    By addButtonBy = By.xpath("//button[text()=' Add ']");
    By firstNameBy = By.cssSelector("input[name='firstName']");
    By lastNameBy = By.cssSelector("input[name='lastName']");
    By employeeIdBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    By searchEmployeeIdBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    By saveButtonBy = By.cssSelector("button[type='submit']");
    By employeeListButtonBy = By.xpath("//a[text()='Employee List']");

    By searchButtonBy = By.xpath("//button[text()=' Search ']");

    By foundEmployeeIdBy = By.xpath("//div[text()='1526']");
    public PimPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickOnPIMButton() {
        WebElement pimButton = driver.findElement(pimButtonBy);
        pimButton.click();
        System.out.println("Pim button clicked");
        Reporter.log("Pim button clicked");
    }

    public void clickOnAddButton() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        Reporter.log("add button clicked");
    }

    public void addNewEmployeeData(String ownEmployeeId) throws InterruptedException {
        WebElement firstName = driver.findElement(firstNameBy);
        firstName.sendKeys("Piramis");
        System.out.println("Piramis is written in Firstname field");
        Reporter.log("Piramis is written in Firstname field");
        WebElement lastName = driver.findElement(lastNameBy);
        lastName.sendKeys("Ferenc");
        System.out.println("Ferenc is written in Lastname field");
        Reporter.log("Ferenc is written in Lastname field");
        WebElement employeeId = driver.findElement(employeeIdBy);
        employeeId.click();
        employeeId.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        System.out.println("Employee Id input field cleared");
        Reporter.log("Employee Id input field cleared");
        employeeId.sendKeys(ownEmployeeId);
        System.out.println(ownEmployeeId+"is written inEmployee id field");
        Reporter.log(ownEmployeeId+"is written inEmployee id field");
    }

    public void clickOnSaveButton(){
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        System.out.println("Save button clicked");
        Reporter.log("Save button clicked");

    }

    public void clickOnEmployeeList(){
        WebElement employeeListButton = driver.findElement(employeeListButtonBy);
        employeeListButton.click();
        System.out.println("EmployeeList button clicked");
        Reporter.log("EmployeeList button clicked");
    }

    public void addEmployeeId(String ownEmployeeId){
        WebElement searchEmployeeId = driver.findElement(searchEmployeeIdBy);
        searchEmployeeId.sendKeys(ownEmployeeId);
        System.out.println(ownEmployeeId+"is written in EmployeeList input field");
        Reporter.log(ownEmployeeId+"is written in EmployeeList input field");
    }

    public void clickOnSearchButton(){
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        System.out.println("Search button clicked");
        Reporter.log("Search button clicked");
    }

    public void checkExistenceOfNewEmployeeInSystem(String ownEmployeeId){
        WebElement foundEmployeeId = driver.findElement(foundEmployeeIdBy);
        Assert.assertEquals(foundEmployeeId.getText(), ownEmployeeId);
        System.out.println("The new employee is found in the system");
        Reporter.log("The new employee is found in the system");
    }
}
