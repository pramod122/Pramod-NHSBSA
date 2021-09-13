package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class AreYouAPregnanetPage extends LandingPage{
    public AreYouAPregnanetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "pregnantOrGivingBirth")
    private List<WebElement> areYouAPregnanet;

    public void amIAPregnant(String areYou) {
        waitForPageLoad();
        Optional<WebElement> countryElement = areYouAPregnanet.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(areYou)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }
}
