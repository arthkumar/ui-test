package com.airbase.page;

import com.airbase.core.PageBase;
import com.airbase.page.component.SortComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListingPage extends PageBase {

    @FindBy(css = "span.a-price-whole")
    private List<WebElement> productPrices;

    @FindBy(xpath = "(//*[@data-component-type='s-product-image'])[1]")
    private WebElement firstProductLink;

    public ProductListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public List<Integer> getProductPrices() {
        return getList(productPrices)
                .stream()
                .map(productPrice -> productPrice.getText().replace(",", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public ProductDetailPage openFirstProduct() {
        clickOn(firstProductLink);
        return new ProductDetailPage(driver);
    }

    public SortComponent navigateToSortSection() {
        return new SortComponent(driver);
    }

}
