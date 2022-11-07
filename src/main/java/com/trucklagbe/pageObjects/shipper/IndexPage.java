package com.trucklagbe.pageObjects.shipper;

import com.trucklagbe.pageObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends Page {
    WebDriver driver;

    private WebElement addShipperButton;
    private WebElement createANewTripButton;
    private WebElement searchButton;
    private WebElement searchInputField;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}
