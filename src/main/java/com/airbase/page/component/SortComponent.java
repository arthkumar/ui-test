package com.airbase.page.component;

import com.airbase.appdata.constants.SortFilter;
import com.airbase.core.PageBase;
import com.airbase.page.ProductListingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SortComponent extends PageBase {

    @FindBy(css = "span.a-dropdown-label")
    private WebElement sortDropdown;

    @FindBy(css = "a.a-dropdown-link")
    private List<WebElement> sortOptions;

    public SortComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public SortComponent clickOnSort() {
        clickOn(sortDropdown);
        return this;
    }

    public ProductListingPage selectSortingOption(SortFilter sortFilter) {
        for (WebElement sortOption : sortOptions) {
            if (sortOption.getText().equalsIgnoreCase(sortFilter.getSortBy())) {
                sortOption.click();
                break;
            }
        }
        return new ProductListingPage(driver);
    }

}
