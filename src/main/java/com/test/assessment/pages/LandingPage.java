package com.test.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends WebPage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "next-button")
    private WebElement startNowButton;

    @FindBy(id = "next-button")
    private WebElement nextButton;


    @FindBy(id="question-heading")
    private WebElement questionHeading;

    public void clickStartNowButton() {
        waitFor(startNowButton).click();
    }

    public void continueNext() {
        waitFor(nextButton).click();
    }

    public void waitForPageLoad() {
        waitFor(questionHeading);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
