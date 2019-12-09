package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;

/** Main category page */
public class MainCategoryPage extends AbstractPage {
    private String FIRST_PRODUCT_XPATH = "(//h5[@itemprop='name']/a)[1]";
    private String SUMMER_DRESSES_XPATH =
            "//ul[@class='tree dynamized']/li/a[contains(text(), 'Summer Dresses')]";
    /**
     * Constructor
     *
     * @param testClass
     */
    public MainCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /** Clicks 1st product on page */
    public ProductPage click1stProduct() {
        super.clickByXpath(FIRST_PRODUCT_XPATH);
        return new ProductPage(testClass);
    }

    /**
     * Navigates to Summer Dresses
     *
     * @return SubCategoryPage
     */
    public SubCategoryPage clickSummerDresses() {
        super.clickByXpath(SUMMER_DRESSES_XPATH);
        return new SubCategoryPage(testClass);
    }
}
