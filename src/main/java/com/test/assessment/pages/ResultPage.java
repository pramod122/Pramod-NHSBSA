package com.test.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends WebPage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "heading-large")
    private WebElement result;

    public boolean isResultAvailable(String resultText) {
        return  waitFor(result).getText().contains(resultText);
    }
}
