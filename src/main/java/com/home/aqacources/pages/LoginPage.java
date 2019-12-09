package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.utils.YamlParser;
import java.io.IOException;
import junit.framework.TestCase;
import org.openqa.selenium.By;

/** Login page */
public class LoginPage extends AbstractPage {
    private String USERNAME_ID = "email";
    private String USERNAME = "testtest123@gmail.com";
    private String PASSWORD_ID = "passwd";
    private String PASSWORD = "Password@123";
    private String SIGN_IN_BUTTON_ID = "SubmitLogin";

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Logins to website
     *
     * @return MyAccountPage
     */
    public MyAccountPage login() {
        try {
            super.fillFieldById(USERNAME_ID, YamlParser.getYamlData().getEmail());
            super.fillFieldById(PASSWORD_ID, YamlParser.getYamlData().getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.clickById(SIGN_IN_BUTTON_ID);
        return new MyAccountPage(testClass);
    }

    /** Checks if current page is a Login page */
    public void verifyPage() {
        if (!(testClass.getDriver().findElements(By.id(USERNAME_ID)).size() > 0))
            TestCase.fail("This is not a login page");
    }
}
