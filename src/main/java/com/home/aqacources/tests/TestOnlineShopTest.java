package com.home.aqacources.tests;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.pages.*;
import org.junit.Test;

public class TestOnlineShopTest extends BaseTest {
    @Test
    public void testProductsCounterTest() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.verifyPage();
        MyAccountPage myAccountPage = loginPage.login();
        MainCategoryPage mainCategoryPage = myAccountPage.verifyFirstLastName();
        mainCategoryPage.goToDresses();
        SubCategoryPage subCategoryPage = mainCategoryPage.clickSummerDresses();
        subCategoryPage.verifyProductsOnPage();
        subCategoryPage.selectWhiteColor();
        subCategoryPage.verifyProductsOnPage();
        subCategoryPage.signOut();
    }

    @Test
    public void testCartTest() {
        HomePage homePage = openSite();
        LoginPage loginPage = homePage.clickSignInButton();
        loginPage.login();
        MainCategoryPage mainCategoryPage = loginPage.goToTshirts();
        ProductPage productPage = mainCategoryPage.click1stProduct();
        productPage.verifyBreadcrumbs();
        productPage.clickAddToCart();
        CheckoutPage checkoutPage = productPage.clickProceedToCheckout();
        checkoutPage.verifyTotalPriceChange();
        checkoutPage.deleteProduct();
        checkoutPage.verifyEmptyCart();
    }
}
