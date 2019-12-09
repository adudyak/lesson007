package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Product page */
public class ProductPage extends AbstractPage {
    private String BREADCRUMBS = "//div[@class='breadcrumb clearfix']";
    private String BREADCRUMBS_EXPECTED = "> Women>Tops>T-shirts>Faded Short Sleeve T-shirts";
    private String ADD_TO_CART_BUTTON = "//button[@name='Submit']";
    private String PRODUCT_ADDED_ICON = "//h2/i[@class='icon-ok']";
    private String PROCEED_TO_CHECKOUT_BUTTON = "//a[@title='Proceed to checkout']";

    /*
    Web elements with @FindBy annotation
     */

    @FindBy(id = "color_24")
    protected WebElement pinkColor;

    @FindBy(id = "uniform-group_1")
    protected WebElement sizeDropDown;

    @FindBy(xpath = "//option[@title='L']")
    protected WebElement sizeL;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    protected WebElement continueShopping;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(BaseTest testClass) {
        super(testClass);
    }

    /** Verifies breadcrumbs */
    public void verifyBreadcrumbs() {
        Assert.assertEquals(
                "Breadcrumbs do not match expected ones",
                BREADCRUMBS_EXPECTED,
                super.getTextFromChildElementsByXpath(BREADCRUMBS));
    }

    /** Adds product to cart */
    public void clickAddToCart() {
        super.clickByXpath(ADD_TO_CART_BUTTON);
        super.waitTillElementIsVisibleByXpath(PRODUCT_ADDED_ICON);
    }

    /**
     * Clicks Proceed to checkout button
     *
     * @return
     */
    public CheckoutPage clickProceedToCheckout() {
        super.clickByXpath(PROCEED_TO_CHECKOUT_BUTTON);
        return new CheckoutPage(testClass);
    }

    /**
     * Clicks Continue Shopping button
     *
     * @return
     */
    public void clickContinueShopping() {
        testClass.waitTillElementIsVisible(continueShopping);
        continueShopping.click();
    }

    /** Selects pink color */
    public void selectPinkColor() {
        testClass.waitTillElementIsVisible(pinkColor);
        pinkColor.click();
    }

    /** Selects L size */
    public void selectLsize() {
        testClass.waitTillElementIsVisible(sizeDropDown);
        sizeDropDown.click();
        testClass.waitTillElementIsVisible(sizeL);
        sizeL.click();
    }
}
