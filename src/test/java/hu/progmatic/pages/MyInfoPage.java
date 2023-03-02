package hu.progmatic.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class MyInfoPage{

    public MyInfoPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    WebDriver driver;
    WebDriverWait wait;

    By myInfoButtonBy = By.xpath("//span[text()='My Info']");
    By personalDetailsTitleBy = By.xpath("//h6[text()='Personal Details']");
    By nameBy = By.xpath("//h6[text()='John Martin']");

    By firstNameFieldBy = By.cssSelector("input[name='firstName']");
    By lastNameFieldBy = By.cssSelector("input[name='lastName']");
    By requiredMessageBy = By.xpath("//span[text()='Required']");

    By saveButtonBy = By.cssSelector("button[type='submit']");

    By employeePhotoBy = By.className("employee-image");

    By changePhotoTitleBy = By.xpath("//h6[text()='Change Profile Picture']");

    By licenseExpiryDateInputFieldBy = By.cssSelector("input[placeholder='yyyy-mm-dd']");
    By errorMessageBy = By.xpath("//span[text()='Should be a valid date in yyyy-mm-dd format']");
    By nationalityDropDownBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]");

    public void navigateToMyInfoPage(){
        WebElement myInfoButton = driver.findElement(myInfoButtonBy);
        myInfoButton.click();
        Reporter.log("My Info Page button clicked");
        WebElement personalDetailsTitle = driver.findElement(personalDetailsTitleBy);
        personalDetailsTitle.isDisplayed();
        Reporter.log("Navigated to My Info Page");
    }

    public void checkRequirementOfFirstName() throws InterruptedException {
        WebElement firstNameField = driver.findElement(firstNameFieldBy);
        Thread.sleep(1000);
        firstNameField.sendKeys(Keys.CONTROL,"a");
        firstNameField.sendKeys(Keys.DELETE);
        Reporter.log("Firstname field cleared");
        WebElement requiredMessage = driver.findElement(requiredMessageBy);
        requiredMessage.isDisplayed();
        Reporter.log("Required message visible");
    }

    public void checkRequirementOfLastName() throws InterruptedException {
        WebElement lastNameField = driver.findElement(lastNameFieldBy);
        Thread.sleep(1000);
        lastNameField.sendKeys(Keys.CONTROL,"a");
        lastNameField.sendKeys(Keys.DELETE);
        Reporter.log("Lastname field cleared");
        WebElement requiredMessage = driver.findElement(requiredMessageBy);
        requiredMessage.isDisplayed();
        Reporter.log("Required message visible");
    }

    public void checkIfFullNameHasBeenSaved() throws InterruptedException {
        WebElement firstNameField = driver.findElement(firstNameFieldBy);
        Thread.sleep(1000);
        firstNameField.sendKeys(Keys.CONTROL,"a");
        firstNameField.sendKeys(Keys.DELETE);
        Reporter.log("Firstname field cleared");
        firstNameField.sendKeys("John");
        Reporter.log("John is written in Firstname field");
        WebElement lastNameField = driver.findElement(lastNameFieldBy);
        lastNameField.sendKeys(Keys.CONTROL,"a");
        lastNameField.sendKeys(Keys.DELETE);
        Reporter.log("Lastname field cleared");
        lastNameField.sendKeys("Martin");
        Reporter.log("Martin is written in Lastname field");
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        Reporter.log("Save button clicked");
        WebElement myInfoButton = driver.findElement(myInfoButtonBy);
        myInfoButton.click();
        Reporter.log("My Info button clicked");
        WebElement name = driver.findElement(nameBy);
        name.isDisplayed();
        Reporter.log("John Martin has been saved");

    }

    public void navigateFromMyInfoToChangeProfilePicturePage(){
        WebElement employeePhoto = driver.findElement(employeePhotoBy);
        employeePhoto.click();
        Reporter.log("Employee photo clicked");
        WebElement changePhotoTitle = driver.findElement(changePhotoTitleBy);
        changePhotoTitle.isDisplayed();
        Reporter.log("Navigated to change photo page");
    }

    public void licenseExpiryDateFieldCheck() throws InterruptedException {
        WebElement licenseExpiryDateInputField = driver.findElement(licenseExpiryDateInputFieldBy);
        Thread.sleep(1000);
        licenseExpiryDateInputField.sendKeys(Keys.NUMPAD1, Keys.TAB);
        Reporter.log("1 is written in License Expiry Date Field");
        WebElement errorMessage = driver.findElement(errorMessageBy);
        errorMessage.isDisplayed();
        Reporter.log("Should be a valid date in yyyy-mm-dd format message is seen");
    }

    public void chosenNationalityCheck(){
        WebElement nationalityDropDown = driver.findElement(nationalityDropDownBy);
        nationalityDropDown.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER);
        Reporter.log("Albanian Nationality is chosen");
        Assert.assertEquals(nationalityDropDown.getText(),"Albanian");
        Reporter.log("Albanian Nationality is visible after choosing it");
    }
}
