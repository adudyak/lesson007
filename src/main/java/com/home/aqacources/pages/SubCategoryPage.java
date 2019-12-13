package com.home.aqacources.pages;

import com.home.aqacources.base.BaseTest;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/** Sub-category page */
public class SubCategoryPage extends AbstractPage {
    /*
    Web elements with @FindBy annotation
    */
    @FindBys({@FindBy(xpath = "//h5[@itemprop='name']")})
    private List<WebElement> productsHeaders;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement productsCounter;

    @FindBy(xpath = "//a[contains(text(),'White')]")
    private WebElement whiteColorLink;

    /**
     * Constructor
     *
     * @param testClass
     */
    public SubCategoryPage(BaseTest testClass) {
        super(testClass);
    }

    /** Verifies if amount of products in counter matches actual result */
    public void verifyProductsOnPage() {
        testClass.log("Verifies if amount of products in counter matches actual result");
        testClass.waitTillElementIsVisible(productsHeaders);
        if (productsHeaders.size() > 1) {
            Assert.assertEquals(
                    "Amount of products on the page does not match counter",
                    "There are " + productsHeaders.size() + " products.",
                    productsCounter.getAttribute("innerHTML"));
        } else
            Assert.assertEquals(
                    "Amount of product on the page does not match counter",
                    "There is " + productsHeaders.size() + " product.",
                    productsCounter.getAttribute("innerHTML"));
    }

    /** Selects white color to filter products */
    public void selectWhiteColor() {
        testClass.log("Selects white color to filter products");
        testClass.waitTillElementIsVisible(whiteColorLink);
    }
}
