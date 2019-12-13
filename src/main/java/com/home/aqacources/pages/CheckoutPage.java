package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Checkout page
 */
public class CheckoutPage extends AbstractPage {
    private String EXPECTED_EMPTY_CART_MESSAGE = "Your shopping cart is empty.";

    /*
    Web elements with @FindBy annotation
    */
    @FindBy(xpath = "//a[@title='Add']")
    private WebElement addProductButton;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement removeProductButton;

    @FindBy(id = "total_product")
    private WebElement totalProductsPrice;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;

    /**
     * Constructor
     *
     * @param testClass
     */
    public CheckoutPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Adds one product to cart by clicking on plus button
     */
    private void addOneProduct() {
        testClass.waitTillElementIsVisible(addProductButton);
        addProductButton.click();
    }

    /**
     * Removes one product from cart by clicking on minus button
     */
    public void removeProduct() {
        testClass.log("Removes one product from cart by clicking on minus button");
        testClass.waitTillElementIsVisible(removeProductButton);
        removeProductButton.click();
    }

    /**
     * Grabs Total price and converts it to int by *100
     *
     * @return
     */
    private int grabTotalPrice() {
        testClass.waitTillElementIsVisible(totalProductsPrice);
        return (int)
                Math.round(
                        100
                                * Double.parseDouble(
                                totalProductsPrice
                                        .getAttribute("innerHTML")
                                        .replace("$", "")));
    }

    /**
     * Verify total prices changes after adding one more product
     */
    public void verifyTotalPriceChange() {
        testClass.log("Verify total prices changes after adding one more product");
        int initialPrice = grabTotalPrice();
        addOneProduct();
        testClass.waitForElementToHaveText(
                totalProductsPrice, "$" + (double) (initialPrice + initialPrice) / 100);
        int updatedPrice = grabTotalPrice();
        Assert.assertEquals(
                "Price does not match expected one", initialPrice + initialPrice, updatedPrice);
    }

    /**
     * Verifies page for empty cart message
     */
    public void verifyEmptyCart() {
        testClass.log("Verifies page for empty cart message");
        testClass.waitTillElementIsVisible(emptyCartMessage);
        Assert.assertEquals(
                "Empty cart message does not match expected one",
                EXPECTED_EMPTY_CART_MESSAGE,
                emptyCartMessage.getAttribute("innerHTML"));
    }
}
