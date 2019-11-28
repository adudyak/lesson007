package com.home.aqacources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;
    private WebDriverWait wait;

    /*
    Web elements with @FindBy annotation
     */

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement pageDiv;

    @FindBy(xpath = "//a[@class='logout']")
    protected WebElement signOut;

    /**
     * Constructor
     *
     * @param driver
     */
    public AbstractPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    /**
     * Wait to load main div
     */
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(pageDiv));
    }

    /**
     * Fill input field with given value
     * @param id
     * @param value
     */
    public void fillFieldById(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    public void signOut() {
        signOut.click();
    }
}
