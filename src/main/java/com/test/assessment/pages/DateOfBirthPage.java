package com.test.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DateOfBirthPage extends LandingPage {

    public DateOfBirthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dob-day")
    private WebElement dayEle;

    @FindBy(id = "dob-month")
    private WebElement monthEle;

    @FindBy(id = "dob-year")
    private WebElement yearEle;

    public void setDay(String day) {
        waitForPageLoad();
        waitFor(dayEle).sendKeys(day);
    }

    public void setMonth(String month) {
        waitForPageLoad();
        waitFor(monthEle).sendKeys(month);
    }

    public void setYear(String year) {
        waitForPageLoad();
        waitFor(yearEle).sendKeys(year);
    }

}
