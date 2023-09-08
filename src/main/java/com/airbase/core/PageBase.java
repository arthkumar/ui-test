package com.airbase.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    public static final int MAX_TIMEOUT = 10;
    protected WebDriver driver;
    WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterValue(WebElement element, String input) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(input);
    }

    public void pressEnter(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.RETURN);
    }

    public List<WebElement> getList(List<WebElement> webElements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public void clickOn(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitUntilPageIsLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> {
            assert webDriver != null;
            return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
        };
        wait.until(pageLoadCondition);
    }

    public boolean isTextVisible(WebElement element, String expectedText) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
