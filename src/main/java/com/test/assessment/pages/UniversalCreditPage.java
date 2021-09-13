package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class UniversalCreditPage extends LandingPage {
    public UniversalCreditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "paidUniversalCredit")
    private List<WebElement> universalCredits;


    public void claimUniversalCredit(String universalCredit) {
        waitForPageLoad();
        Optional<WebElement> countryElement = universalCredits.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(universalCredit)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("GP must be from UK");
        }
    }

}
