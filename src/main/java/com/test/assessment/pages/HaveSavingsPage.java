package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class HaveSavingsPage extends LandingPage{
    public HaveSavingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "haveSavings")
    private List<WebElement> haveSavingsEle;

    public void haveSavings(String have) {
        waitForPageLoad();
        Optional<WebElement> countryElement = haveSavingsEle.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(have)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }


}
