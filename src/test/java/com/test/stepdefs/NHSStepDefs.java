package com.test.stepdefs;

import com.test.assessment.driver.WebDriverProvider;
import com.test.assessment.pages.*;
import com.test.assessment.utilities.PropertiesManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class NHSStepDefs {

    private WebDriverProvider provider = WebDriverProvider.getInstance();
    WebDriver driver = provider.get();
    private LandingPage landingPage = new LandingPage(driver);
    private CountryPage countryPage = new CountryPage(driver);
    private DateOfBirthPage dateOfBirthPage = new DateOfBirthPage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private GPPracticePage gpPracticePage = new GPPracticePage(driver);
    private LiveWithPartnerPage liveWithPartnerPage = new LiveWithPartnerPage(driver);
    private ClaimBenefitsPage claimBenefitsPage = new ClaimBenefitsPage(driver);
    private InjuryIllnessPage injuryIllnessPage = new InjuryIllnessPage(driver);
    private LiveInCareHomePage liveInCareHomePage = new LiveInCareHomePage(driver);
    private HaveSavingsPage haveSavingsPage = new HaveSavingsPage(driver);
    private LiveInHighLandsPage liveInHighLandsPage = new LiveInHighLandsPage(driver);
    private AreYouAPregnanetPage areYouAPregnanetPage = new AreYouAPregnanetPage(driver);
    private DiseasePage diabetesPage = new DiseasePage(driver);
    private GetHelpForCareHomePage getHelpForCareHomePage = new GetHelpForCareHomePage(driver);

    @Given("I am a person from {string}")
    public void iAmAPersonFrom(String country) {
        countryPage.chooseCountry(country);
    }

    @And("I am under {int}")
    public void iAmUnder(int age) {
        Date date = DateUtils.addYears(new Date(), -14);
        int day = date.getDate();
        int month = date.getMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        dateOfBirthPage.setDay(String.valueOf(day));
        dateOfBirthPage.setMonth(String.valueOf(month));
        dateOfBirthPage.setYear(String.valueOf(year));
        dateOfBirthPage.continueNext();
    }

    @And("I am over {int}")
    public void iAmOver(int age) {
        Date date = DateUtils.addYears(new Date(), -20);
        int day = date.getDate();
        int month = date.getMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        dateOfBirthPage.setDay(String.valueOf(day));
        dateOfBirthPage.setMonth(String.valueOf(month));
        dateOfBirthPage.setYear(String.valueOf(year));
        dateOfBirthPage.continueNext();
    }

    @And("I am senior citizen")
    public void iAmSeniorCitizen() {
        Date date = DateUtils.addYears(new Date(), -61);
        int day = date.getDate();
        int month = date.getMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        dateOfBirthPage.setDay(String.valueOf(day));
        dateOfBirthPage.setMonth(String.valueOf(month));
        dateOfBirthPage.setYear(String.valueOf(year));
        dateOfBirthPage.continueNext();
    }

    @Then("I should get a result {string}")
    public void iShouldGetAResult(String arg0) {
        Assert.assertTrue(resultPage.isResultAvailable(arg0));
    }

    @And("My GP practice is in Scotland or Wales")
    public void myGPPracticeIsInScotlandOrWales() {
        gpPracticePage.gpFromEngland("Yes");
    }

    @And("I {string} with partner")
    public void iWithPartner(String arg0) {
        String value = arg0.equalsIgnoreCase("live")? "Yes": "No";
        liveWithPartnerPage.liveWithPartner(value);
    }

    @And("I {string} Benefits or tax credits")
    public void iBenefitsOrTaxCredits(String arg0) {
        String value = arg0.equalsIgnoreCase("claim")? "Yes": "No";
        claimBenefitsPage.claimAnyBenefits(value);
    }

    @And("I {string} injuries while serving armed forces")
    public void iInjuriesWhileServingArmedForces(String arg0) {
        String value = arg0.equalsIgnoreCase("have")? "Yes": "No";
        injuryIllnessPage.injured(value);
    }

    @And("I or my partner permanently {string} in a care home")
    public void iOrMyPartnerPermanentlyInACareHome(String arg0) {
        String value = arg0.equalsIgnoreCase("live")? "Yes": "No";
        liveInCareHomePage.liveInCareHome(value);
    }

    @And("I or my partner have {string} savings")
    public void iOrMyPartnerHaveMoreSavings(String have) {
        String value = have.equalsIgnoreCase("more")? "Yes": "No";
        haveSavingsPage.haveSavings(value);
    }

    @Given("I am on NHS Home Page")
    public void iAmOnNHSHomePage() {
        driver.get(PropertiesManager.get().getProperty("application.url"));
        landingPage.clickStartNowButton();
    }

    @And("I {string} in Highlands")
    public void iInHighlands(String arg0) {
        String value = arg0.equalsIgnoreCase("live")? "Yes": "No";
        liveInHighLandsPage.liveInHighLands(value);
    }

    @And("I am {string} pregnant or given a birth in the last {int} months")
    public void iAmPregnantOrGivenABirthInTheLastMonths(String arg0, int arg1) {
        String value = arg0.equalsIgnoreCase("not a")? "No": "Yes";
        areYouAPregnanetPage.amIAPregnant(value);
    }

    @And("I do {string} diabetes")
    public void iDoDiabetes(String arg0) {
        String value = arg0.equalsIgnoreCase("not have")? "No": "Yes";
        diabetesPage.haveDiabetes(value);
    }

    @And("I do {string} glucoma")
    public void iDoGlucoma(String arg0) {
        String value = arg0.equalsIgnoreCase("not have")? "No": "Yes";
        diabetesPage.haveGlucoma(value);
    }

    @And("I {string} help to pay for care home")
    public void iHelpToPayForCareHome(String arg0) {
        String value = arg0.equalsIgnoreCase("get")? "Yes": "No";
        getHelpForCareHomePage.gpHelpForCareHome(value);
    }

    @After
    public void after() {
        driver.quit();
    }
}
