package dataprovider;

import com.airbase.appdata.builder.TestDataBuilder;
import org.testng.annotations.DataProvider;

public class AirbaseDataProvider {

    @DataProvider()
    public Object[][] eCommerceTest() {
        return new Object[][]{
                {TestDataBuilder.tcID001()},
                {TestDataBuilder.tcID002()},
                {TestDataBuilder.tcID003()}
        };
    }
}
