package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class LiveInHighLandsPage extends LandingPage {
    public LiveInHighLandsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "livingInHighlandsAndIslands")
    private List<WebElement> liveInHighLands;

    public void liveInHighLands(String live) {
        waitForPageLoad();
        Optional<WebElement> countryElement = liveInHighLands.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(live)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }
}
