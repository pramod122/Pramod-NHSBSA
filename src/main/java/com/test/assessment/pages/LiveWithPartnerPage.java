package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class LiveWithPartnerPage extends LandingPage{
    public LiveWithPartnerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "partner")
    public List<WebElement> liveWithPartnerEle;

    public void liveWithPartner(String liveWithPartner) {
        waitForPageLoad();
        Optional<WebElement> countryElement = liveWithPartnerEle.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(liveWithPartner)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option is not given");
        }
        continueNext();
    }


}
