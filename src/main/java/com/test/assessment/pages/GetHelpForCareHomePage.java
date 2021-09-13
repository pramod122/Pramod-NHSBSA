package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class GetHelpForCareHomePage extends LandingPage{
    public GetHelpForCareHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "localCouncilAssessed")
    private List<WebElement> getHelpForCareHome;


    public void gpHelpForCareHome(String getCare) {
        waitForPageLoad();
        Optional<WebElement> countryElement = getHelpForCareHome.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(getCare)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("GP must be from UK");
        }
        continueNext();
    }
}
