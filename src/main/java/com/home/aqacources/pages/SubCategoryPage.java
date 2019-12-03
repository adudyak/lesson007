package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.junit.Assert;

/** Sub-category page */
public class SubCategoryPage extends AbstractPage {
    private String SUMMER_DRESSES_XPATH =
            "//ul[@class='tree dynamized']/li/a[contains(text(), 'Summer Dresses')]";
    private String PRODUCT_XPATH = "//h5[@itemprop='name']";
    private String PRODUCTS_COUNTER_TEXT = "//span[@class='heading-counter']";
    private String WHITE_LINK_XPATH = "//a[contains(text(),'White')]";

    /**
     * Constructor
     *
     * @param testClass
     */
    public SubCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /** Navigates to Summer Dresses */
    public void clickSummerDresses() {
        super.clickByXpath(SUMMER_DRESSES_XPATH);
    }

    /** Verifies amount of products in counter matches actual result */
    public void verifyProductsOnPage() {
        if (super.countElementsByXpath(PRODUCT_XPATH) > 1) {
            Assert.assertEquals(
                    "Amount of products on the page does not match counter",
                    "There are " + super.countElementsByXpath(PRODUCT_XPATH) + " products.",
                    super.getTextByXpath(PRODUCTS_COUNTER_TEXT));
        } else
            Assert.assertEquals(
                    "Amount of product on the page does not match counter",
                    "There is " + super.countElementsByXpath(PRODUCT_XPATH) + " product.",
                    super.getTextByXpath(PRODUCTS_COUNTER_TEXT));
    }

    /** Selects white color to filter products */
    public void selectWhiteColor() {
        super.clickByXpath(WHITE_LINK_XPATH);
    }
}
