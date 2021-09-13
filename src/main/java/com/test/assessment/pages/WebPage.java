package com.test.assessment.pages;

import com.test.assessment.utilities.PropertiesManager;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebPage {

    private WebDriver driver;
    final PropertiesManager propertiesManager = PropertiesManager.get();
    private final Integer timeOutInSec = Integer.valueOf(propertiesManager.getProperty("element.wait.sec"));

    public WebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitFor(WebElement element) {
        By by = getBy(element);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        WebElement el = wait.pollingEvery(Duration.ofMillis(1000)).until(driver1 -> {
            try {
                return driver1.findElement(by);
            } catch (NoSuchElementException | StaleElementReferenceException ignored) {
            }
            return null;
        });
        if (el == null) {
            throw new NoSuchElementException(by.toString());
        }
        return el;
    }

    private By getBy(WebElement element) {
        try {
            Object proxyOrigin = FieldUtils.readField(element, "h", true);
            Object locator = FieldUtils.readField(proxyOrigin, "locator", true);
            Object findBy = FieldUtils.readField(locator, "by", true);
            return (By) findBy;
        } catch (IllegalAccessException | StaleElementReferenceException ignored) {
        }
        return null;
    }
}
