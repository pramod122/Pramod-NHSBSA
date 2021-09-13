package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class ClaimBenefitsPage extends LandingPage{
    public ClaimBenefitsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "benefitsOrTaxCredits")
    private List<WebElement> claimBenefits;

    public void claimAnyBenefits(String claim) {
        waitForPageLoad();
        Optional<WebElement> countryElement = claimBenefits.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(claim)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("GP must be from UK");
        }
        continueNext();
    }

}
