package com.home.aqacources.tests;

import com.home.aqacources.pages.*;
import org.junit.Test;

public class TestSignInSignOutTest extends BaseTest {
    @Test
    public void testSignInSignOutTest() {
        HomePage homePage = goToHomePage();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.verifyPage();
        MyAccountPage myAccountPage = loginPage.login();
        MainCategoryPage mainCategoryPage = myAccountPage.verifyFirstLastName();
        SubCategoryPage subCategoryPage = mainCategoryPage.goToDresses();
    }
}
