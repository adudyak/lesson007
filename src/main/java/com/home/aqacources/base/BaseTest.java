package com.home.aqacources.base;

import com.home.aqacources.pages.HomePage;
import com.home.aqacources.utils.YamlParser;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Basic test to start/stop webdriver, open home page */
public class BaseTest {
    // Webdriver + wait + actions
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    // Logger
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // Rule
    @Rule public RunTestRules runTestRules = new RunTestRules(this);

    /** Webdriver start and setup of browser options */
    public BaseTest() {
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

        action = new Actions(driver);
    }

    /**
     * Opens site and get instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        log("Opens site");
        try {
            driver.get(YamlParser.getYamlData().getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HomePage(this);
    }

    /**
     * Gets instance of driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets instance of Actions
     *
     * @return action
     */
    public Actions getAction() {
        return action;
    }

    /**
     * Waits till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits till 1st element from list of elements is visible
     *
     * @param list
     */
    public void waitTillElementIsVisible(List<WebElement> list) {
        wait.until(ExpectedConditions.visibilityOf(list.get(0)));
    }

    /**
     * Waits till element has certain text
     *
     * @param element
     * @param text
     */
    public void waitForElementToHaveText(WebElement element, String text) {
        waitTillElementIsVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Writes down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Writes down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Gets date and time
     *
     * @return SimpleDateFormat
     */
    public String getDateTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /** Switches to new window */
    public void switchToNewWindow() {
        log("Switches to new window");
        String actualWindow = getDriver().getWindowHandle();
        Set<String> windows = getDriver().getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(actualWindow)) {
                newWindow = window;
            }
        }

        getDriver().switchTo().window(newWindow);
    }

    /** Closes window and switches to other window */
    public void closeWindowAndSwitchToOther() {
        log("Closes window and switches to other window");
        String actualWindow = getDriver().getWindowHandle();
        Set<String> windows = getDriver().getWindowHandles();
        String newWindow = null;
        for (String window : windows) {
            if (!window.equals(actualWindow)) {
                newWindow = window;
            }
        }
        getDriver().switchTo().window(actualWindow).close();
        getDriver().switchTo().window(newWindow);
    }

    /** Quits WebDriver */
    public void quitWebDriver() {
        getDriver().close();
        getDriver().quit();
    }
}
