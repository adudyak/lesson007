package com.home.aqacources.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage {
    private String FIRST_LAST_NAME = "FirstName lastName";
    private String FIRST_LAST_NAME_XPATH = "//a[@class='account']/span";

    /**
     * Constructor
     *
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void verifyFirstLastName() {
        Assert.assertEquals("First Last name does not match expected one", FIRST_LAST_NAME, getTextByXpath(FIRST_LAST_NAME_XPATH));
    }
}
