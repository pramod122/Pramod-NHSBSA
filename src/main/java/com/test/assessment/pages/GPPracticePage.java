package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class GPPracticePage extends LandingPage {
    public GPPracticePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "gpPracticeInScotlandOrWales")
    private List<WebElement> gpPracticeYesNo;


    public void gpFromEngland(String isFromEngland) {
        waitForPageLoad();
        Optional<WebElement> countryElement = gpPracticeYesNo.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(isFromEngland)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("GP must be from UK");
        }
        continueNext();
    }


}
