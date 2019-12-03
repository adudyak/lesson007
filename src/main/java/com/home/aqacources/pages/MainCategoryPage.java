package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;

/** Main category page */
public class MainCategoryPage extends AbstractPage {
    private String DRESSES_XPATH = "//div/ul/li/a[@title='Dresses']";

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
}
