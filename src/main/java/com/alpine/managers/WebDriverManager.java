package com.alpine.managers;

import com.alpine.enums.DriverType;
import com.alpine.enums.EnvironmentType;
import com.alpine.enums.OperatingSystemType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    private static OperatingSystemType operatingSystemType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
        operatingSystemType = FileReaderManager.getInstance().getConfigReader().getOperatingSystemType();
    }

    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath() + "chromedriver_" + operatingSystemType.toString().toLowerCase());
                String user_data_dir = "--user-data-dir=" + System.getProperty("user.dir") + "/" + FileReaderManager.getInstance().getConfigReader().getUserDataDirForChromeOptions() + "";
                System.out.println(user_data_dir);
                ChromeOptions options = new ChromeOptions();
                options.addArguments(user_data_dir);
//                options.addArguments("--user-data-dir=/home/rakibul/Workstation/ruby-selenium-automation/user_data");
//                options.addArguments("--user-data-dir=/home/rakibul/Workstation/automation/behaviour-driven-development-with-cucumber/chrome_data_dir");
//                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//                options.addArguments("--disable-extentions");
//                options.addArguments("--profile-directory=Profile 1");
                driver = new ChromeDriver(options);
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
