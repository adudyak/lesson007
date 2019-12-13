package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Abstract page with common methods */
public abstract class AbstractPage {
    protected BaseTest testClass;

    private String EXPECTED_SIZE_COLOR = "Pink, L";
    private String EXPECTED_EMPTY_CART_TEXT = "(empty)";

    /*
    Web elements with @FindBy annotation
    */
    @FindBy(xpath = "//div[@id='page']")
    private WebElement mainPageDiv;

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutLink;

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
    private WebElement tShirtsLink;

    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    private WebElement dressesLink;

    @FindBy(xpath = "//div/ul/li/a[@title='Women']")
    private WebElement womenLink;

    @FindBy(xpath = "//div/ul/li/ul/li/ul/li/a[@title='Evening Dresses']")
    private WebElement eveningDressesLink;

    @FindBy(xpath = "(//h5[@itemprop='name']/a)[1]")
    private WebElement firstProductLink;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//div[@class='product-atributes']/a")
    private WebElement productAttributesLink;

    @FindBy(xpath = "//span[@class='remove_link']/a")
    private WebElement removeProductLink;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private WebElement emptyCartMessage;

    /**
     * Abstract page receives BaseTest
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this); // Initialize WebElements
        testClass.waitTillElementIsVisible(mainPageDiv);
    }

    /**
     * Clicks Sign In button
     *
     * @return LoginPage
     */
    public LoginPage clickSignInButton() {
        testClass.log("Clicks Sign In button");
        testClass.waitTillElementIsVisible(signInLink);
        signInLink.click();
        return new LoginPage(testClass);
    }

    /** Signs out */
    public void signOut() {
        testClass.log("Signs out");
        testClass.waitTillElementIsVisible(signOutLink);
        signOutLink.click();
    }

    /**
     * Clicks 1st product on page
     *
     * @return ProductPage
     */
    public ProductPage open1stProduct() {
        testClass.log("Clicks 1st product on page");
        testClass.waitTillElementIsVisible(firstProductLink);
        firstProductLink.click();
        return new ProductPage(testClass);
    }

    /**
     * Opens 1st product in new window
     *
     * @return ProductPage
     */
    public ProductPage open1stProductNewWindow() {
        testClass.log("Opens 1st product in new window");
        testClass.waitTillElementIsVisible(firstProductLink);
        firstProductLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        testClass.switchToNewWindow();
        return new ProductPage(testClass);
    }

    /**
     * Navigates to T-Shirts category
     *
     * @return MainCategoryPage
     */
    public MainCategoryPage goToTshirts() {
        testClass.log("Navigates to T-Shirts category");
        testClass.waitTillElementIsVisible(tShirtsLink);
        tShirtsLink.click();
        return new MainCategoryPage(testClass);
    }

    /**
     * Navigates to Dresses category
     *
     * @return MainCategoryPage
     */
    public MainCategoryPage goToDresses() {
        testClass.log("Navigates to Dresses category");
        testClass.waitTillElementIsVisible(dressesLink);
        dressesLink.click();
        return new MainCategoryPage(testClass);
    }

    /** Moves mouse over Women category */
    public void mouseOverWomen() {
        testClass.log("Moves mouse over Women category");
        testClass.waitTillElementIsVisible(womenLink);
        testClass.getAction().moveToElement(womenLink).perform();
    }

    /**
     * Navigates to Evening Dresses category
     *
     * @return SubCategoryPage
     */
    public SubCategoryPage goToEveningDresses() {
        testClass.log("Navigates to Evening Dresses category");
        testClass.waitTillElementIsVisible(eveningDressesLink);
        eveningDressesLink.click();
        return new SubCategoryPage(testClass);
    }

    /** Moves mouse over Cart */
    public void mouseOverCart() {
        testClass.log("Moves mouse over Cart");
        testClass.waitTillElementIsVisible(cartLink);
        testClass.getAction().moveToElement(cartLink).perform();
    }

    /** Verifies correct size and color are in cart */
    public void verifySizeAndColor() {
        testClass.log("Verifies correct size and color are in cart");
        testClass.waitTillElementIsVisible(productAttributesLink);
        Assert.assertEquals(
                "Size and/or color do not match expected one(s)",
                EXPECTED_SIZE_COLOR,
                productAttributesLink.getAttribute("innerHTML"));
    }

    /** Removes product from cart */
    public void removeProduct() {
        testClass.log("Removes product from cart");
        testClass.waitTillElementIsVisible(removeProductLink);
        removeProductLink.click();
    }

    /** Verifies cart is empty */
    public void verifyCartIsEmpty() {
        testClass.log("Verifies cart is empty");
        testClass.waitTillElementIsVisible(emptyCartMessage);
        Assert.assertEquals(
                "Empty cart text does not match expected one",
                EXPECTED_EMPTY_CART_TEXT,
                emptyCartMessage.getAttribute("innerHTML"));
    }

    /** Prints cookies */
    public void printCookies() {
        testClass.log("Prints cookies");
        Set<Cookie> cookies = testClass.getDriver().manage().getCookies();
        System.out.println("Cookies: " + cookies.size());
        System.out.println(cookies.toString());
    }

    /**
     * Compares breadcrumbs from element with given string
     *
     * @param element
     * @param breadcrumbs
     */
    public void verifyBreadcrumbs(WebElement element, String breadcrumbs) {
        testClass.waitTillElementIsVisible(element);
        Assert.assertEquals(
                "Breadcrumbs do not match expected ones",
                breadcrumbs,
                element.getText());
    }
}
