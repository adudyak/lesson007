package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;

/** Main page of website */
public class HomePage extends AbstractPage {
    private String SIGN_IN_BUTTON_XPATH = "//a[contains(text(), 'Sign in')]";

    /**
     * Constructor
     *
     * @param testClass
     */
    public HomePage(BaseTest testClass) {
        super(testClass);
    }
}
