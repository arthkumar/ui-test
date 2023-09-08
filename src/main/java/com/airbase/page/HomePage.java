package com.airbase.page;

import com.airbase.core.PageBase;
import com.airbase.page.component.SearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {
    @FindBy(xpath = "//div[@class='a-box-inner']/div[1]/img")
    private WebElement captcha;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public HomePage navigateToHomePage(String route){
        driver.get(route);
        return this;
    }

    public boolean isCaptchaVisible() {
        return isElementVisible(captcha);
    }

    public SearchComponent navigateToSearchSection() {
        return new SearchComponent(driver);
    }
}

