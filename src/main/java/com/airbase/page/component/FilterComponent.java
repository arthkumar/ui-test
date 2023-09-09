package com.airbase.page.component;

import com.airbase.core.PageBase;
import com.airbase.page.ProductListingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterComponent extends PageBase {

    @FindBy(id = "low-price")
    private WebElement minPriceInput;
    @FindBy(id = "high-price")
    private WebElement maxPriceInput;
    @FindBy(xpath = "//ul[@aria-labelledby='p_89-title']/span/li/span")
    private List<WebElement> brandFilters;

    public FilterComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public ProductListingPage selectBrandFilter(String brandFilter) {
        for (WebElement actualBrandFilter : brandFilters) {
            if (actualBrandFilter.getText().equalsIgnoreCase(brandFilter.toLowerCase())) {
                actualBrandFilter.click();
                break;
            }
        }
        return new ProductListingPage(driver);
    }

    public FilterComponent selectPriceFilter(String from, String to) {
        enterValue(minPriceInput, from);
        enterValue(maxPriceInput, to);
        pressEnter(maxPriceInput);
        return new FilterComponent(driver);
    }

}
