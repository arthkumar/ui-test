package com.airbase.page;

import com.airbase.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends PageBase {

    private String mainWindow;
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id = "attach-close_sideSheet-link")
    private WebElement closeIcon;

    @FindBy(id = "nav-cart-count")
    private WebElement cartButton;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilPageIsLoaded();
    }

    public boolean isProductDetailsPageVisible() {
        waitUntilPageIsLoaded();
        return addToCartButton.isDisplayed();
    }

    public ProductDetailPage switchToWindow() {
        mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        return this;
    }

    public ProductDetailPage clickOnAddToCartBtn() {
        clickOn(addToCartButton);
        return this;
    }

    public ProductDetailPage closePopUp() {
        clickOn(closeIcon);
        return this;
    }

    public boolean getCartItemCount(String expectedOutput) {
        return isTextVisible(cartButton, expectedOutput);
    }

    public void closeSwitch() {
        driver.close();
        driver.switchTo().window(mainWindow);
    }
}
