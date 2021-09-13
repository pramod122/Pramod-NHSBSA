package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class CountryPage extends LandingPage {
    public CountryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "livingCountry")
    private List<WebElement> country;

    public void chooseCountry(String countryName) {
        waitForPageLoad();
        Optional<WebElement> countryElement = country.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(countryName)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException(countryName + "option is not available");
        }
        continueNext();
    }
}
