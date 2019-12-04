package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;

/**
 * Checkout page
 */
public class CheckoutPage extends AbstractPage {
    private String ADD_PRODUCT_BUTTON = "//a[@title='Add']";
    private String REMOVE_PRODUCT_BUTTON = "//a[@title='Delete']";
    private String TOTAL_PRICE = "total_price";
    private String EMPTY_CART_MESSAGE = "//p[@class='alert alert-warning']";
    private String EXPECTED_EMPTY_CART_MESSAGE = "Your shopping cart is empty.";

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
    public void addOneProduct() {
        super.clickByXpath(ADD_PRODUCT_BUTTON);
    }

    /**
     * Removes one product from cart by clicking on minus button
     */
    public void deleteProduct() {
        super.clickByXpath(REMOVE_PRODUCT_BUTTON);
    }

    /**
     * Grabs Total price and converts it to int by *100
     *
     * @return
     */
    public int grabTotalPrice() {
        return (int) Math.round(100 * Double.parseDouble(super.getTextById(TOTAL_PRICE).replace("$", "")));
    }

    /**
     * Verify total prices changes after adding one more product
     */
    public void verifyTotalPriceChange() {
        int initialPrice = grabTotalPrice();
        addOneProduct();
        int updatedPrice = grabTotalPrice();
        Assert.assertEquals(
                "Price does not match expected one",
                initialPrice + initialPrice,
                updatedPrice);
    }

    /**
     * Verifies page for empty cart message
     */
    public void verifyEmptyCart() {
        Assert.assertEquals(
                "Empty cart message does not match expected one",
                EXPECTED_EMPTY_CART_MESSAGE,
                super.getTextByXpath(EMPTY_CART_MESSAGE));
    }
}
