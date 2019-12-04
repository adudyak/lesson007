package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;

/** Main page after login */
public class MyAccountPage extends AbstractPage {
    private String FIRST_LAST_NAME_EXPECTED = "FirstName lastName";
    private String FIRST_LAST_NAME_XPATH = "//a[@class='account']/span";

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Verifies if First/Last names on page match expected ones
     *
     * @return MainCategoryPage
     */
    public MainCategoryPage verifyFirstLastName() {
        Assert.assertEquals(
                "First Last name does not match expected one",
                FIRST_LAST_NAME_EXPECTED,
                super.getTextByXpath(FIRST_LAST_NAME_XPATH));
        return new MainCategoryPage(testClass);
    }
}
