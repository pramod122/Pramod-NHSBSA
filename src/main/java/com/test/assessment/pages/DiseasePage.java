package com.test.assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class DiseasePage extends LandingPage{
    public DiseasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "diabetes")
    private List<WebElement> diabetes;

    @FindBy(name = "glaucoma")
    private List<WebElement> glucoma;

    public void haveDiabetes(String have) {
        waitForPageLoad();
        Optional<WebElement> countryElement = diabetes.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(have)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }

    public void haveGlucoma(String have) {
        waitForPageLoad();
        Optional<WebElement> countryElement = glucoma.stream().filter(x->
                x.getAttribute("value").equalsIgnoreCase(have)).findFirst();
        if(countryElement.isPresent()) {
            countryElement.get().findElement(By.xpath("..")).click();
        } else {
            throw new RuntimeException("Valid Option must be given");
        }
        continueNext();
    }

}
