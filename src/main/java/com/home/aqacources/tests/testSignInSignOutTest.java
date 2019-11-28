package com.home.aqacources.tests;

import com.home.aqacources.pages.*;
import org.junit.Test;

public class testSignInSignOutTest extends BaseTest {
    @Test
    public void testOpenSiteAndClickPythonLinkTest() {
        // Initialize pages
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        // Go to HomePage
        homePage.goToHomePage();

        // Click on Sign In Button
        homePage.clickSignInButton();

        // Login
        loginPage.login();

        // Verify First Last name
        myAccountPage.verifyFirstLastName();

        // Logout
        myAccountPage.signOut();

        // Verify login page
        loginPage.verifyPage();
    }
}
