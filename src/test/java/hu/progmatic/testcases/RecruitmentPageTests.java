package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.RecruitmentPage;
import org.testng.annotations.Test;

public class RecruitmentPageTests extends DriverBaseTest {

    LoginPage loginPage;
    RecruitmentPage recruitmentPage;

    @Test
    public void createNewCandidateTest() throws InterruptedException {
        loginPage = new LoginPage(driver,wait);
        loginPage.LoginWithValidUserValidPass();
        recruitmentPage = new RecruitmentPage(driver, wait);
        recruitmentPage.recruitmentButtonClick();
        recruitmentPage.addButtonClick();
        recruitmentPage.addNewCandidateData();
        recruitmentPage.saveButtonClick();
        recruitmentPage.checkIfNewlyAddedCandidateExists();
    }



}
