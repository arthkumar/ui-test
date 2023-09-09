package base;

import com.airbase.appdata.constants.BrowserType;
import com.airbase.core.BrowserFactory;
import com.airbase.page.HomePage;
import dev.failsafe.RetryPolicy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class TestBase {

    private WebDriver driver;
    private HomePage homePage;
    private RetryPolicy<Object> retryPolicy;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory(BrowserType.CHROME).getDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        retryPolicy = RetryPolicy.builder()
                .handle(AssertionError.class)
                .withDelay(Duration.ofSeconds(1))
                .withMaxRetries(3)
                .build();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
