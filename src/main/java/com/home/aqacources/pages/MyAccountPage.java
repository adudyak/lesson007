package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Main page after login */
public class MyAccountPage extends AbstractPage {
    private String FIRST_LAST_NAME_EXPECTED = "FirstName lastName";

    /*
    Web elements with @FindBy annotation
    */
    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement firstLastNamesText;

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
        testClass.log("Verifies if First/Last names on page match expected ones");
        testClass.waitTillElementIsVisible(firstLastNamesText);
        Assert.assertEquals(
                "First Last name does not match expected one",
                FIRST_LAST_NAME_EXPECTED,
                firstLastNamesText.getAttribute("innerHTML"));
        return new MainCategoryPage(testClass);
    }
}
