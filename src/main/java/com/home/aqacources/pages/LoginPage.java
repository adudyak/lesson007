package com.home.aqacources.pages;

import com.home.aqacources.tests.BaseTest;
import junit.framework.TestCase;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private String USERNAME_ID = "email";
    private String USERNAME = "testtest123@gmail.com";
    private String PASSWORD_ID = "passwd";
    private String PASSWORD = "Password@123";
    private String SIGN_IN_BUTTON_ID = "SubmitLogin";

    /**
     * Constructor
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
    }

    public MyAccountPage login() {
        testClass.fillFieldById(USERNAME_ID, USERNAME);
        testClass.fillFieldById(PASSWORD_ID, PASSWORD);
        testClass.clickById(SIGN_IN_BUTTON_ID);
        return new MyAccountPage(testClass);
    }
    public void verifyPage() {
        if (!(testClass.getDriver().findElements(By.id(USERNAME_ID)).size() > 0)) TestCase.fail("This is not a login page");
    }
}
