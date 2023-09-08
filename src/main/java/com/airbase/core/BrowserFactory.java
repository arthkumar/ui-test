package com.airbase.core;

import com.airbase.appdata.constants.BrowserType;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Getter
public class BrowserFactory {

    private final WebDriver driver;

    public BrowserFactory(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
    }
}