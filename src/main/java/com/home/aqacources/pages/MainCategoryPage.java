package com.home.aqacources.pages;

import com.home.aqacources.tests.BaseTest;

public class MainCategoryPage extends AbstractPage {
    private String DRESSES_XPATH = "(//a[@title='Dresses'])[1]";

    public MainCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    public SubCategoryPage goToDresses() {
        testClass.clickByXpath(DRESSES_XPATH);
        return new SubCategoryPage(testClass);
    }
}
