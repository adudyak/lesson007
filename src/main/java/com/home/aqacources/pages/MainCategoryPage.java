package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;

/** Main category page */
public class MainCategoryPage extends AbstractPage {
    private String DRESSES_XPATH = "//div/ul/li/a[@title='Dresses']";
    private String TSHIRTS_XPATH = "//div/ul/li/a[@title='T-shirts']";
    private String FIRST_PRODUCT_XPATH = "(//h5[@itemprop='name']/a)[1]";

    /**
     * Constructor
     *
     * @param testClass
     */
    public MainCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Navigates to Dresses category
     *
     * @return SubCategoryPage
     */
    public SubCategoryPage goToDresses() {
        super.clickByXpath(DRESSES_XPATH);
        return new SubCategoryPage(testClass);
    }

    /**
     * Navigates to T-shirts category
     */
    public void goToTshirts() {
        super.clickByXpath(TSHIRTS_XPATH);
    }

    /**
     * Clicks 1st product on page
     */
    public ProductPage click1stProduct(){
        super.clickByXpath(FIRST_PRODUCT_XPATH);
        return new ProductPage(testClass);
    }
}
