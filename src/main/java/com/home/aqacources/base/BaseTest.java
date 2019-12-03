package com.home.aqacources.base;

import com.home.aqacources.pages.HomePage;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Basic test to start/stop webdriver, open home page */
public class BaseTest {
    private String HOME_PAGE = "http://automationpractice.com";

    private WebDriver driver;
    private WebDriverWait wait;

    /** Webdriver start and setup of browser options */
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

    /** Quit webdriver */
    @After
    public void tearDrop() {
        driver.quit();
    }

    /**
     * Returns instance of webdriver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Waits for given element to become visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Opens homepage
     *
     * @return HomePage
     */
    public HomePage goToHomePage() {
        driver.get(HOME_PAGE);
        return new HomePage(this);
    }
}
