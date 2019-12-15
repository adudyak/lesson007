package com.home.aqacources.tests;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.pages.*;
import org.junit.Test;

public class TestOnlineShopTest extends BaseTest {
    @Test
    public void testProductsCounterTest() {
        // Open home page
        HomePage homePage = openSite();
        // Click Sign In button
        LoginPage loginPage = homePage.clickSignInButton();
        // Verify Login page
        loginPage.verifyPage();
        // Login to store
        MyAccountPage myAccountPage = loginPage.login();
        // Verify First and Last name on page
        MainCategoryPage mainCategoryPage = myAccountPage.verifyFirstLastName();
        // Navigate to Dresses category
        mainCategoryPage.goToDresses();
        // Navigate to Summer Dresses subcategory
        SubCategoryPage subCategoryPage = mainCategoryPage.clickSummerDresses();
        // Verify if amount of products in counter matches actual result
        subCategoryPage.verifyProductsOnPage();
        // Select White color to filter products
        subCategoryPage.selectWhiteColor();
        // Verify if amount of products in counter matches actual result
        subCategoryPage.verifyProductsOnPage();
        // Sign out
        subCategoryPage.signOut();
    }

    @Test
    public void testCartTest() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.login();
        loginPage.goToTshirts();
        ProductPage productPage = loginPage.open1stProduct();
        productPage.verifyProductBreadcrumbs();
        productPage.clickAddToCart();
        CheckoutPage checkoutPage = productPage.clickProceedToCheckout();
        checkoutPage.verifyTotalPriceChange();
        checkoutPage.removeProduct();
        checkoutPage.verifyEmptyCart();
    }

    @Test
    public void testActionsAndCookies() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.login();
        loginPage.mouseOverWomen();
        loginPage.goToEveningDresses();
        ProductPage productPage = loginPage.open1stProductNewWindow();
        productPage.selectPinkColor();
        productPage.selectLsize();
        productPage.clickAddToCart();
        productPage.clickContinueShopping();
        productPage.mouseOverCart();
        productPage.verifySizeAndColor();
        productPage.removeProduct();
        productPage.verifyCartIsEmpty();
        closeWindowAndSwitchToOther();
        productPage.printCookies();
    }
}
