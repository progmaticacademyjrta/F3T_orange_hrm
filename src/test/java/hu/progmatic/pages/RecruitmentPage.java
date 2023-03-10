package hu.progmatic.pages;

import hu.progmatic.report.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class RecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;
    Reporting reporting;

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
        reporting = new Reporting();
        WebElement candidates = driver.findElement(candidatesBy);
        candidates.isDisplayed();
        reporting.sendDateAndReportMessage("Navigated to Recruitment page");
    }

    public void addButtonClick() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        reporting = new Reporting();
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.isDisplayed();
        reporting.sendDateAndReportMessage("Navigated to add Candidate page");
    }

    public void addNewCandidateData() throws InterruptedException {
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys("Piramis");
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Piramis is written in Firstname field");
        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys("Kata");
        reporting.sendDateAndReportMessage("Kata is written in Lastname field");
        WebElement vacancyDropDown = driver.findElement(vacancyDropDownBy);
        vacancyDropDown.click();
        vacancyDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        reporting.sendDateAndReportMessage("Junior Account Assistant is chosen from the Vacancy list");
        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.sendKeys("piramiskata@mail.hu");
        reporting.sendDateAndReportMessage("piramiskata@mail.hu is written in Email field");
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        reporting.sendDateAndReportMessage("piramiskata is written in Keywords field");
        WebElement dateOfApplicationInput = driver.findElement(dateOfApplicationInputBy);
        dateOfApplicationInput.sendKeys("");
        reporting.sendDateAndReportMessage("Today's date is given in Date of Application field");
        WebElement consentToKeepDate = driver.findElement(consentToKeepDateBy);
        consentToKeepDate.click();
        reporting.sendDateAndReportMessage("Consent to keep data is accepted");
        reporting.sendDateAndReportMessage("Candidate data filled");
    }

    public void saveButtonClick() throws InterruptedException {
        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Data saved");
    }

    public void checkIfNewlyAddedCandidateExists() throws InterruptedException {
        WebElement candidates = driver.findElement(candidatesBy);
        candidates.click();
        reporting = new Reporting();
        reporting.sendDateAndReportMessage("Candidates Button clicked");
        WebElement keywordsInput = driver.findElement(keywordsInputBy);
        keywordsInput.sendKeys("piramiskata");
        reporting.sendDateAndReportMessage("piramiskata is written in Keywords field");
        WebElement dateOfApplicationFrom = driver.findElement(dateOfApplicationFromBy);
        dateOfApplicationFrom.sendKeys("1998-02-21");
        reporting.sendDateAndReportMessage("1998-02-21 is written in Date Of Application From field");
        WebElement dateOfApplicationTo = driver.findElement(dateOfApplicationToBy);
        dateOfApplicationTo.sendKeys("2024-02-24");
        reporting.sendDateAndReportMessage("2024-02-24 is written in Date Of Application To field");
        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        reporting.sendDateAndReportMessage("Search Button clicked");
        WebElement recordFound = driver.findElement(recordFoundBy);
        recordFound.isDisplayed();
        reporting.sendDateAndReportMessage("Successfully found candidate");
    }

}
