package com.home.aqacources.pages;

import com.home.aqacources.tests.BaseTest;
import org.junit.Assert;

public class MyAccountPage extends AbstractPage {
    private String FIRST_LAST_NAME = "FirstName lastName";
    private String FIRST_LAST_NAME_XPATH = "//a[@class='account']/span";

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
    }

    public MainCategoryPage verifyFirstLastName() {
        Assert.assertEquals("First Last name does not match expected one", FIRST_LAST_NAME, testClass.getTextByXpath(FIRST_LAST_NAME_XPATH));
        return new MainCategoryPage(testClass);
    }
}
