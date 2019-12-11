package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.utils.YamlParser;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Login page */
public class LoginPage extends AbstractPage {
    /*
    Web elements with @FindBy annotation
     */
    @FindBy(id = "email")
    protected WebElement emailInput;

    @FindBy(id = "passwd")
    protected WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    protected WebElement signInButton;

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
        testClass.log("Logins to website");
        testClass.waitTillElementIsVisible(emailInput);
        testClass.waitTillElementIsVisible(passwordInput);
        testClass.waitTillElementIsVisible(signInButton);
        try {
            emailInput.sendKeys(YamlParser.getYamlData().getEmail());
            passwordInput.sendKeys(YamlParser.getYamlData().getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        signInButton.click();
        return new MyAccountPage(testClass);
    }

    /** Checks if current page is a Login page */
    public void verifyPage() {
        testClass.log("Checks if current page is a Login page");
        testClass.waitTillElementIsVisible(emailInput);
    }
}
