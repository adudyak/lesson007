package com.home.aqacources.tests;

import com.home.aqacources.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Collections;

public class BaseTest {
    private String HOME_PAGE = "http://automationpractice.com";

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDrop() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillFieldById(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    public HomePage goToHomePage() {
        driver.get(HOME_PAGE);
        return new HomePage(this);
    }
}
