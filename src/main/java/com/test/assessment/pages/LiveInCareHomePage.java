package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class LiveInCareHomePage extends LandingPage {
    public LiveInCareHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "inCareHome")
    private List<WebElement> liveInCareHomeEle;

    public void liveInCareHome(String live) {
        waitForPageLoad();
        Optional<WebElement> countryElement = liveInCareHomeEle.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(live)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }

}
