package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;

/** Main category page */
public class MainCategoryPage extends AbstractPage {
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
