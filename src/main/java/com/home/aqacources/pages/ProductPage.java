package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;

/** Product page */
public class ProductPage extends AbstractPage {
    private String BREADCRUMBS = "//div[@class='breadcrumb clearfix']";
    private String BREADCRUMBS_EXPECTED = "> Women>Tops>T-shirts>Faded Short Sleeve T-shirts";
    private String ADD_TO_CART_BUTTON = "//button[@name='Submit']";
    private String PRODUCT_ADDED_ICON = "//h2/i[@class='icon-ok']";
    private String PROCEED_TO_CHECKOUT_BUTTON = "//a[@title='Proceed to checkout']";

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
                super.getTextFromChildElementsXpath(BREADCRUMBS));
    }

    /** Adds product to cart */
    public void clickAddToCart() {
        super.clickByXpath(ADD_TO_CART_BUTTON);
        super.waitTillXpathElementIsVisible(PRODUCT_ADDED_ICON);
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
}
