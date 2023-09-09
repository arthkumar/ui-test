package base;

import com.airbase.appdata.constants.BrowserType;
import com.airbase.core.BrowserFactory;
import dev.failsafe.RetryPolicy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class TestBase {

    private WebDriver driver;
    private RetryPolicy<Object> retryPolicy;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory(BrowserType.CHROME).getDriver();
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
