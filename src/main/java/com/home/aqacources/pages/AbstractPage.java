package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div/ul/li/a[@title='Women']")
    protected WebElement women;

    @FindBy(xpath = "//div/ul/li/ul/li/ul/li/a[@title='Evening Dresses']")
    protected WebElement eveningDresses;

    @FindBy(xpath = "(//h5[@itemprop='name']/a)[1]")
    protected WebElement firstProduct;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    protected WebElement cart;

    @FindBy(xpath = "//div[@class='product-atributes']/a")
    protected WebElement productAttributes;

    @FindBy(xpath = "//span[@class='remove_link']/a")
    protected WebElement removeProductLink;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    protected WebElement emptyCart;

    private String EXPECTED_SIZE_COLOR = "Pink, L";
    private String EXPECTED_EMPTY_CART_TEXT = "(empty)";

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
    public String getTextFromChildElementsByXpath(String xpath) {
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
    public void waitTillElementIsVisibleByXpath(String xpath) {
        testClass.waitTillElementIsVisible(testClass.getDriver().findElement(By.xpath(xpath)));
    }

    /**
     * Waits till element has certain text
     *
     * @param id, text
     * @param text
     */
    public void waitForElementToHaveTextById(String id, String text) {
        testClass.waitForElementToHaveText(testClass.getDriver().findElement(By.id(id)), text);
    }

    /** Clicks 1st product on page */
    public ProductPage open1stProduct() {
        testClass.waitTillElementIsVisible(firstProduct);
        firstProduct.click();
        return new ProductPage(testClass);
    }

    /** Opens 1st product in new window */
    public ProductPage open1stProductNewWindow() {
        testClass.waitTillElementIsVisible(firstProduct);
        firstProduct.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        testClass.switchToNewWindow();
        return new ProductPage(testClass);
    }

    /**
     * Navigates to T-Shorts category
     *
     * @return MaonCategoryPage
     */
    public MainCategoryPage goToTshirts() {
        testClass.waitTillElementIsVisible(tShirts);
        tShirts.click();
        return new MainCategoryPage(testClass);
    }

    /**
     * Navigates to Dresses category
     *
     * @return MainCategoryPage
     */
    public MainCategoryPage goToDresses() {
        testClass.waitTillElementIsVisible(dresses);
        dresses.click();
        return new MainCategoryPage(testClass);
    }

    /** Moves mouse over Women category */
    public void mouseOverWomen() {
        testClass.waitTillElementIsVisible(women);
        testClass.getAction().moveToElement(women).perform();
    }

    /** Navigates to Evening Dresses category */
    public SubCategoryPage goToEveningDresses() {
        testClass.waitTillElementIsVisible(eveningDresses);
        eveningDresses.click();
        return new SubCategoryPage(testClass);
    }

    /** Moves mouse over Cart */
    public void mouseOverCart() {
        testClass.waitTillElementIsVisible(cart);
        testClass.getAction().moveToElement(cart).perform();
    }

    /** Verifies correct size and color are in cart */
    public void verifySizeAndColor() {
        testClass.waitTillElementIsVisible(productAttributes);
        Assert.assertEquals(
                "Size and/or color do not match expected one(s)",
                EXPECTED_SIZE_COLOR,
                productAttributes.getAttribute("innerHTML"));
    }

    /** Removes product from cart */
    public void removeProduct() {
        testClass.waitTillElementIsVisible(removeProductLink);
        removeProductLink.click();
    }

    /** Verifies cart is empty */
    public void verifyCartIsEmpty() {
        testClass.waitTillElementIsVisible(emptyCart);
        Assert.assertEquals(
                "Empty cart text does not match expected one",
                EXPECTED_EMPTY_CART_TEXT,
                emptyCart.getAttribute("innerHTML"));
    }

    /** Closes active window */
    public void closeWindow() {
        testClass.closeWindowAndSwitchToOther();
    }

    /** Prints cookies */
    public void printCookies() {
        Set<Cookie> cookies = testClass.getDriver().manage().getCookies();
        System.out.println("Cookies: " + cookies.size());
        System.out.println(cookies.toString());
    }
}
