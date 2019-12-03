package com.home.aqacources.pages;

import com.home.aqacources.tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected BaseTest testClass;

    /*
    Web elements with @FindBy annotation
     */

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement pageDiv;

    @FindBy(xpath = "//a[@class='logout']")
    protected WebElement signOut;

    /**
     * Constructor
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this); // Initialize WebElements
        testClass.waitTillElementIsVisible(pageDiv);
    }

    public void signOut() {
        signOut.click();
    }
}
