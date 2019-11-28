package com.home.aqacources.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private String SIGN_IN_BUTTON_XPATH = "//a[contains(text(), 'Sign in')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public void clickSignInButton() {
        waitForPageLoad();
        clickByXpath(SIGN_IN_BUTTON_XPATH);
    }
}


