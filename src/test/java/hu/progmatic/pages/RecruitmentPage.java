package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

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
        Reporter.log("Navigated to Recruitment page");
    }

    public void addButtonClick() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.isDisplayed();
        System.out.println("Navigated to add Candidate page");
        Reporter.log("Navigated to add Candidate page");
    }

    public void addNewCandidateData() throws InterruptedException {
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys("Piramis");
        System.out.println("Piramis is written in Firstname field");
        Reporter.log("Piramis is written in Firstname field");
        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys("Kata");
        System.out.println("Kata is written in Lastname field");
        Reporter.log("Kata is written in Lastname field");
        WebElement vacancyDropDown = driver.findElement(vacancyDropDownBy);
        vacancyDropDown.click();
        vacancyDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        System.out.println("Junior Account Assistant is chosen from the Vacancy list");
        Reporter.log("Junior Account Assistant is chosen from the Vacancy list");
        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.sendKeys("piramiskata@mail.hu");
        System.out.println("piramiskata@mail.hu is written in Email field");
        Reporter.log("piramiskata@mail.hu is written in Email field");
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        System.out.println("piramiskata is written in Keywords field");
        Reporter.log("piramiskata is written in Keywords field");
        WebElement dateOfApplicationInput = driver.findElement(dateOfApplicationInputBy);
        dateOfApplicationInput.sendKeys("");
        System.out.println("Today's date is given in Date of Application field");
        Reporter.log("Today's date is given in Date of Application field");
        WebElement consentToKeepDate = driver.findElement(consentToKeepDateBy);
        consentToKeepDate.click();
        System.out.println("Consent to keep data is accepted");
        Reporter.log("Consent to keep data is accepted");
        System.out.println("Candidate data filled");
        Reporter.log("Candidate data filled");
    }

    public void saveButtonClick() throws InterruptedException {
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        System.out.println("Data saved.");
        Reporter.log("Data saved");
    }

    public void checkIfNewlyAddedCandidateExists() throws InterruptedException {
        WebElement candidates = driver.findElement(candidatesBy);
        candidates.click();
        System.out.println("Candidates Button clicked");
        Reporter.log("Candidates Button clicked");
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        System.out.println("piramiskata is written in Keywords field");
        Reporter.log("piramiskata is written in Keywords field");
        WebElement dateOfApplicationFrom = driver.findElement(dateOfApplicationFromBy);
        dateOfApplicationFrom.sendKeys("1998-02-21");
        System.out.println("1998-02-21 is written in Date Of Application From field");
        Reporter.log("1998-02-21 is written in Date Of Application From field");
        WebElement dateOfApplicationTo = driver.findElement(dateOfApplicationToBy);
        dateOfApplicationTo.sendKeys("2024-02-24");
        System.out.println("2024-02-24 is written in Date Of Application To field");
        Reporter.log("2024-02-24 is written in Date Of Application To field");
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        System.out.println("Search Button clicked");
        Reporter.log("Search Button clicked");
        WebElement recordFound = driver.findElement(recordFoundBy);
        recordFound.isDisplayed();
        System.out.println("Successfully found candidate.");
        Reporter.log("Successfully found candidate");

    }

}
