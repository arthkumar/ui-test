package com.airbase.core;

import com.airbase.appdata.constants.BrowserType;
import com.airbase.exception.AirbaseRuntimeException;
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
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new AirbaseRuntimeException("Invalid browser type: " + browserType);
        }
    }
}