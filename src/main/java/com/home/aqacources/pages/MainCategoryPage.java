package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Main category page */
public class MainCategoryPage extends AbstractPage {
    /*
    Web elements with @FindBy annotation
     */
    @FindBy(xpath = "//ul[@class='tree dynamized']/li/a[contains(text(), 'Summer Dresses')]")
    protected WebElement summerDressesLink;

    /**
     * Constructor
     *
     * @param testClass
     */
    public MainCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Navigates to Summer Dresses
     *
     * @return SubCategoryPage
     */
    public SubCategoryPage clickSummerDresses() {
        testClass.log("Navigates to Summer Dresses");
        testClass.waitTillElementIsVisible(summerDressesLink);
        summerDressesLink.click();
        return new SubCategoryPage(testClass);
    }
}
