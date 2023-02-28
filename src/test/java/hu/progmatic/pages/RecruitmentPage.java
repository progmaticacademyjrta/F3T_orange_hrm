package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public RecruitmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By recruitmentButtonBy = By.xpath("//span[text()='Recruitment']");
    By addButtonBy = By.xpath("//button[text()=' Add ']");
    By firstNameInputBy = By.name("firstName");
    By lastNameInputBy = By.name("lastName");
    By vacancyDropDownBy = By.className("oxd-select-text-input");
    By emailInputBy = By.cssSelector("input[placeholder='Type here']");
    By keywordsInputBy = By.cssSelector("input[placeholder='Enter comma seperated words...']");
    By dateOfApplicationInputBy = By.cssSelector("input[placeholder='yyyy-mm-dd']");
    By consentToKeepDateBy = By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
    By saveButtonBy = By.cssSelector("button[type='submit']");
    By candidatesBy = By.xpath("//a[text()='Candidates']");
    By dateOfApplicationFromBy = By.cssSelector("input[placeholder='From']");
    By dateOfApplicationToBy = By.cssSelector("input[placeholder='To']");
    By searchButtonBy = By.cssSelector("button[type='submit']");
    By recordFoundBy = By.xpath("//div[text()='Piramis  Kata']");

    public void recruitmentButtonClick() throws InterruptedException {
        WebElement recruitmentButton = driver.findElement(recruitmentButtonBy);
        recruitmentButton.click();
        WebElement candidates = driver.findElement(candidatesBy);
        candidates.isDisplayed();
        System.out.println("Navigated to Recruitment page");
    }

    public void addButtonClick() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.isDisplayed();
        System.out.println("Navigated to add Candidate page");
    }

    public void addNewCandidateData() throws InterruptedException {
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys("Piramis");
        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys("Kata");
        WebElement vacancyDropDown = driver.findElement(vacancyDropDownBy);
        vacancyDropDown.click();
        vacancyDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.sendKeys("piramiskata@mail.hu");
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        WebElement dateOfApplicationInput = driver.findElement(dateOfApplicationInputBy);
        dateOfApplicationInput.sendKeys("");
        WebElement consentToKeepDate = driver.findElement(consentToKeepDateBy);
        consentToKeepDate.click();
        System.out.println("Candidate data filled");
    }

    public void saveButtonClick() throws InterruptedException {
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        System.out.println("Data saved.");
    }

    public void checkIfNewlyAddedCandidateExists() throws InterruptedException {
        WebElement candidates = driver.findElement(candidatesBy);
        candidates.click();
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        WebElement dateOfApplicationFrom = driver.findElement(dateOfApplicationFromBy);
        dateOfApplicationFrom.sendKeys("1998-02-21");
        WebElement dateOfApplicationTo = driver.findElement(dateOfApplicationToBy);
        dateOfApplicationTo.sendKeys("2024-02-24");
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        WebElement recordFound = driver.findElement(recordFoundBy);
        recordFound.isDisplayed();
        System.out.println("Successfully found candidate.");

    }

}
