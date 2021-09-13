package com.test.assessment.driver;

import com.test.assessment.utilities.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

    private String browser = PropertiesManager.get().getProperty("browser");

    private static WebDriverProvider webDriverProvider;

    public WebDriver get() {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":  {
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }

            default: {
                driver = new ChromeDriver();
                break;
            }
        }
        return driver;
    }

    public static  WebDriverProvider getInstance() {
        if(webDriverProvider == null) {
            webDriverProvider = new WebDriverProvider();
        }
        return webDriverProvider;
    }
}
