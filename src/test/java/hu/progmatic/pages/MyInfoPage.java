package hu.progmatic.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        WebElement personalDetailsTitle = driver.findElement(personalDetailsTitleBy);
        personalDetailsTitle.isDisplayed();

    }

    public void checkRequirementOfFirstName() throws InterruptedException {
        WebElement firstNameField = driver.findElement(firstNameFieldBy);
        firstNameField.sendKeys(Keys.CONTROL,"a");
        firstNameField.sendKeys(Keys.DELETE);
        WebElement requiredMessage = driver.findElement(requiredMessageBy);
        requiredMessage.isDisplayed();
    }

    public void checkRequirementOfLastName() throws InterruptedException {
        WebElement lastNameField = driver.findElement(lastNameFieldBy);
        lastNameField.sendKeys(Keys.CONTROL,"a");
        lastNameField.sendKeys(Keys.DELETE);
        WebElement requiredMessage = driver.findElement(requiredMessageBy);
        requiredMessage.isDisplayed();
    }

    public void checkIfFullNameHasBeenSaved(){
        WebElement firstNameField = driver.findElement(firstNameFieldBy);
        firstNameField.sendKeys(Keys.CONTROL,"a");
        firstNameField.sendKeys(Keys.DELETE);
        firstNameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(lastNameFieldBy);
        lastNameField.sendKeys(Keys.CONTROL,"a");
        lastNameField.sendKeys(Keys.DELETE);
        lastNameField.sendKeys("Martin");
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        WebElement myInfoButton = driver.findElement(myInfoButtonBy);
        myInfoButton.click();
        WebElement name = driver.findElement(nameBy);
        name.isDisplayed();

    }

    public void navigateFromMyInfoToChangeProfilePicturePage(){
        WebElement employeePhoto = driver.findElement(employeePhotoBy);
        employeePhoto.click();
        WebElement changePhotoTitle = driver.findElement(changePhotoTitleBy);
        changePhotoTitle.isDisplayed();
    }

    public void licenseExpiryDateFieldCheck() throws InterruptedException {
        WebElement licenseExpiryDateInputField = driver.findElement(licenseExpiryDateInputFieldBy);
        licenseExpiryDateInputField.sendKeys(Keys.NUMPAD1, Keys.TAB);
        WebElement errorMessage = driver.findElement(errorMessageBy);
        errorMessage.isDisplayed();
    }

    public void chosenNationalityCheck(){
        WebElement nationalityDropDown = driver.findElement(nationalityDropDownBy);
        nationalityDropDown.sendKeys(Keys.DOWN,Keys.DOWN,Keys.ENTER);
        Assert.assertEquals(nationalityDropDown.getText(),"Albanian");
    }
}
