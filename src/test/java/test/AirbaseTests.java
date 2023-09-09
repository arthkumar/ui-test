package test;

import base.TestBase;
import com.airbase.appdata.model.TestData;
import com.airbase.page.HomePage;
import com.airbase.page.ProductDetailPage;
import com.airbase.page.ProductListingPage;
import dataprovider.AirbaseDataProvider;
import dev.failsafe.Failsafe;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.airbase.appdata.constants.Route.QA;

public class AirbaseTests extends TestBase {

    @Test(dataProviderClass = AirbaseDataProvider.class, dataProvider = "eCommerceTest")
    public void testEcommerceAutomation(TestData testData) {

        HomePage homePage = new HomePage(getDriver());
        Failsafe.with(getRetryPolicy()).run(() -> {
            homePage.navigateToHomePage(QA);
            boolean isPageTitleValid = homePage.getPageTitle().toLowerCase().contains(testData.getExpectedPageTitle().toLowerCase());
            Assert.assertTrue(isPageTitleValid);
            Assert.assertFalse(homePage.isCaptchaVisible());
        });

        ProductListingPage plp = homePage.navigateToSearchSection()
                .enterInput(testData.getProductType())
                .selectPriceFilter(testData.getFromPrice(), testData.getToPrice())
                .selectBrandFilter(testData.getBrandFilter());

        plp.getProductPrices().forEach(productPrice -> {
            boolean isInBetweenRange = productPrice >= Integer.parseInt(testData.getFromPrice()) && productPrice <= Integer.parseInt(testData.getToPrice());
            Assert.assertTrue(isInBetweenRange);
        });

        ProductDetailPage pdp = plp.navigateToSortSection()
                .clickOnSort()
                .selectSortingOption(testData.getSortFilter())
                .openFirstProduct()
                .switchToWindow();

        Assert.assertTrue(pdp.isProductDetailsPageVisible());

        pdp.clickOnAddToCartBtn().closePopUp();
        Assert.assertTrue(pdp.getCartItemCount(testData.getExpectedItemCount()));
        pdp.closeSwitch();
    }

}
