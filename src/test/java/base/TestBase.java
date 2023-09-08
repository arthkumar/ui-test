package base;

import com.airbase.appdata.constants.BrowserType;
import com.airbase.core.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory(BrowserType.CHROME).getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
