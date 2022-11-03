package runners.trips.bidding;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinitions.trips"},
        features = "src/test/resources/functionalTests/trips/BiddingTripCreate.feature",
        plugin = {
//                "features.support.GlobalHook",
                "pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/Cucumber.html",
                "json:target/cucumber-report/cucumber.json"
        },
        tags = "@using_shipper_phone",
        monochrome = true
)
//public class BiddingTripCreateRunner extends AbstractTestNGCucumberTests {
//}

public class BiddingTripCreateRunner {
}
