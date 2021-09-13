package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class InjuryIllnessPage extends LandingPage{
    public InjuryIllnessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "warPension")
    private List<WebElement> injuredEle;

    public void injured(String isInjured) {
        waitForPageLoad();
        Optional<WebElement> countryElement = injuredEle.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(isInjured)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }
}
