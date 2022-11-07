package com.trucklagbe.pageObjects.owner;

import com.trucklagbe.pageObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends Page {
    private WebDriver driver;

    private WebElement addOwnerButton;
    private WebElement searchButton;
    private WebElement searchOwnerInputField;

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }
}
