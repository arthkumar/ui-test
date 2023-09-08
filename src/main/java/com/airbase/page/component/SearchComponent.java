package com.airbase.page.component;

import com.airbase.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchComponent extends PageBase {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    public SearchComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public FilterComponent enterInput(String inputText) {
        enterValue(searchTextBox, inputText);
        pressEnter(searchTextBox);
        return new FilterComponent(driver);
    }
}
