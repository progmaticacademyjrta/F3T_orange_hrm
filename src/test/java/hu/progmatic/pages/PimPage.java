package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    By foundEmployeeIdBy = By.xpath("//div[text()='1234567812']");
    public PimPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void clickOnPIMButton() {
        WebElement pimButton = driver.findElement(pimButtonBy);
        pimButton.click();
    }

    public void clickOnAddButton() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
    }

    public void addNewEmployeeData(String ownEmployeeId) throws InterruptedException {
        WebElement firstName = driver.findElement(firstNameBy);
        firstName.sendKeys("Gerebenes12");
        WebElement lastName = driver.findElement(lastNameBy);
        lastName.sendKeys("Karcsi12");
        WebElement employeeId = driver.findElement(employeeIdBy);
        employeeId.click();
        employeeId.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        employeeId.sendKeys(ownEmployeeId);
    }

    public void clickOnSaveButton(){
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();

    }

    public void clickOnEmployeeList(){
        WebElement employeeListButton = driver.findElement(employeeListButtonBy);
        employeeListButton.click();
    }

    public void addEmployeeId(String ownEmployeeId){
        WebElement searchEmployeeId = driver.findElement(searchEmployeeIdBy);
        searchEmployeeId.sendKeys(ownEmployeeId);
    }

    public void clickOnSearchButton(){
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
    }

    public void checkExistenceOfNewEmployeeInSystem(String ownEmployeeId){
        WebElement foundEmployeeId = driver.findElement(foundEmployeeIdBy);
        Assert.assertEquals(foundEmployeeId.getText(), ownEmployeeId);
    }
}
