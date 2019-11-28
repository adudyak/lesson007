package com.home.aqacources.pages;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private String USERNAME_ID = "email";
    private String USERNAME = "testtest123@gmail.com";
    private String PASSWORD_ID = "passwd";
    private String PASSWORD = "Password@123";
    private String SIGN_IN_BUTTON_ID = "SubmitLogin";

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        waitForPageLoad();
        fillFieldById(USERNAME_ID, USERNAME);
        fillFieldById(PASSWORD_ID, PASSWORD);
        clickById(SIGN_IN_BUTTON_ID);
    }
    public void verifyPage() {
        waitForPageLoad();
        if (!(driver.findElements(By.id(USERNAME_ID)).size() > 0)) TestCase.fail("This is not a login page");
    }
}
