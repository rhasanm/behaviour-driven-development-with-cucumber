package runners.shipper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinitions"},
        features = "src/test/resources/functionalTests/shipper/AddNewShipper.feature",
        plugin = {
//                "support.GlobalHook",
                "pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/Cucumber.html",
        },
//        tags = "@add_new_shipper",
        monochrome = true
)
public class AddNewShipperRunnerTest {}