package com.home.aqacources.pages;

import com.home.aqacources.tests.BaseTest;

public class HomePage extends AbstractPage {
    private String SIGN_IN_BUTTON_XPATH = "//a[contains(text(), 'Sign in')]";

    public HomePage(BaseTest testClass) {
        super(testClass);
    }

    public LoginPage clickSignInButton() {
        testClass.clickByXpath(SIGN_IN_BUTTON_XPATH);
        return new LoginPage(testClass);
    }
}


