package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Abstract page with common methods */
public abstract class AbstractPage {
    protected BaseTest testClass;

    /*
    Web elements with @FindBy annotation
     */

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement pageDiv;

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    protected WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    protected WebElement signOut;

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
    protected WebElement tShirts;

    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    protected WebElement dresses;

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

    /**
     * Clicks Sign In button
     *
     * @return LoginPage
     */
    public LoginPage clickSignInButton() {
        testClass.waitTillElementIsVisible(signIn);
        signIn.click();
        return new LoginPage(testClass);
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
     * Returns text from all element's children, found by xpath
     *
     * @param xpath
     * @return
     */
    public String getTextFromChildElementsXpath(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
        return testClass.getDriver().findElement(By.xpath(xpath)).getText();
    }

    /**
     * Returns innerHTML of element, found by id
     *
     * @param id
     * @return String
     */
    public String getTextById(String id) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.id(id)));
        return testClass.getDriver().findElement(By.id(id)).getAttribute("innerHTML");
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

    /**
     * Waits for element to be visible
     *
     * @param xpath
     */
    public void waitTillXpathElementIsVisible(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
    }

    /**
     * Waits till element has certain text
     *
     * @param id, text
     * @param text
     */
    public void waitForIdElementToHaveText(String id, String text) {
        testClass.waitForElementToHaveText(testClass.getDriver().findElement(By.id(id)), text);
    }

    /**
     * Navigates to T-Shorts category
     *
     * @return MaonCategoryPage
     */
    public MainCategoryPage goToTshirts() {
        tShirts.click();
        return new MainCategoryPage(testClass);
    }

    /**
     * Navigates to Dresses category
     *
     * @return MainCategoryPage
     */
    public MainCategoryPage goToDresses() {
        dresses.click();
        return new MainCategoryPage(testClass);
    }
}
