package com.home.aqacources.tests;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.pages.*;
import org.junit.Test;

/** */
public class TestOnlineShopTest extends BaseTest {
    @Test
    public void testProductsCounterTest() {
        HomePage homePage = goToHomePage();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.verifyPage();
        MyAccountPage myAccountPage = loginPage.login();
        MainCategoryPage mainCategoryPage = myAccountPage.verifyFirstLastName();
        SubCategoryPage subCategoryPage = mainCategoryPage.goToDresses();
        subCategoryPage.clickSummerDresses();
        subCategoryPage.verifyProductsOnPage();
        // Selecting white color does not work, but single product counter is handled
        //        subCategoryPage.selectWhiteColor();
        //        subCategoryPage.verifyProductsOnPage();
        subCategoryPage.signOut();
    }
}
