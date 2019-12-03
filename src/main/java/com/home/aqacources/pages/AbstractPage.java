package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.openqa.selenium.By;
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
     * Abstract page receives BaseTest
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this); // Initialize WebElements
        testClass.waitTillElementIsVisible(pageDiv);
    }

    /** Signs out */
    public void signOut() {
        signOut.click();
    }

    /**
     * Fills field, found by id, with value
     *
     * @param id
     * @param value
     */
    public void fillFieldById(String id, String value) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.id(id)));
        testClass.getDriver().findElement(By.id(id)).sendKeys(value);
    }

    /**
     * Clicks element, found by id
     *
     * @param id
     */
    public void clickById(String id) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.id(id)));
        testClass.getDriver().findElement(By.id(id)).click();
    }

    /**
     * Clicks element, found by XPath
     *
     * @param xpath
     */
    public void clickByXpath(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
        testClass.getDriver().findElement(By.xpath(xpath)).click();
    }

    /**
     * Returns innerHTML of element, found by XPath
     *
     * @param xpath
     * @return String
     */
    public String getTextByXpath(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
        return testClass.getDriver().findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    /**
     * Returns amount of elements, found by XPath
     *
     * @param xpath
     * @return int
     */
    public int countElementsByXpath(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
        return testClass.getDriver().findElements(By.xpath(xpath)).size();
    }
}
