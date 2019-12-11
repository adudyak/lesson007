package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Product page */
public class ProductPage extends AbstractPage {
    private String BREADCRUMBS_EXPECTED = "> Women>Tops>T-shirts>Faded Short Sleeve T-shirts";

    /*
    Web elements with @FindBy annotation
     */
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    protected WebElement breadcrumbs;

    @FindBy(xpath = "//button[@name='Submit']")
    protected WebElement addToCartButton;

    @FindBy(xpath = "//h2/i[@class='icon-ok']")
    protected WebElement productIsAddedIcon;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    protected WebElement proceedToCheckoutButton;

    @FindBy(id = "color_24")
    protected WebElement pinkColorButton;

    @FindBy(id = "uniform-group_1")
    protected WebElement sizeDropDown;

    @FindBy(xpath = "//option[@title='L']")
    protected WebElement sizeLoption;

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
        testClass.log("Verifies breadcrumbs");
        testClass.waitTillElementIsVisible(breadcrumbs);
        Assert.assertEquals(
                "Breadcrumbs do not match expected ones",
                BREADCRUMBS_EXPECTED,
                breadcrumbs.getText());
    }

    /** Adds product to cart */
    public void clickAddToCart() {
        testClass.log("Adds product to cart");
        testClass.getAction().moveToElement(addToCartButton).perform();
        testClass.waitTillElementIsVisible(addToCartButton);
        addToCartButton.click();
        testClass.waitTillElementIsVisible(productIsAddedIcon);
    }

    /**
     * Clicks Proceed to checkout button
     *
     * @return CheckoutPage
     */
    public CheckoutPage clickProceedToCheckout() {
        testClass.log("Clicks Proceed to checkout button");
        testClass.waitTillElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new CheckoutPage(testClass);
    }

    /** Clicks Continue Shopping button */
    public void clickContinueShopping() {
        testClass.log("Clicks Continue Shopping button");
        testClass.waitTillElementIsVisible(continueShopping);
        continueShopping.click();
    }

    /** Selects pink color */
    public void selectPinkColor() {
        testClass.log("Selects pink color");
        testClass.waitTillElementIsVisible(pinkColorButton);
        pinkColorButton.click();
    }

    /** Selects L size */
    public void selectLsize() {
        testClass.log("Selects L size");
        testClass.waitTillElementIsVisible(sizeDropDown);
        sizeDropDown.click();
        testClass.waitTillElementIsVisible(sizeLoption);
        sizeLoption.click();
    }
}
