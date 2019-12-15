package com.home.aqacources.tests;

import com.home.aqacources.base.BaseTest;
import com.home.aqacources.pages.HomePage;
import com.home.aqacources.pages.LoginPage;
import com.home.aqacources.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActionsAndCookiesCucumberTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
    }

    @When("He clicks Sign In Button sees Login page")
    public void heClicksSignInSeesLoginPage() {
        loginPage = homePage.clickSignInButton();
    }

    @Then("He logins to site")
    public void heLoginsToSite() {
        loginPage.login();
    }

    @When("User moves mouse over Women category sees subcategories")
    public void userMouseOverWomenSeesSubcategories() {
        loginPage.mouseOverWomen();
    }

    @Then("He navigates to Evening Dresses subcategory")
    public void heNavigatesToEveningDresses() {
        loginPage.goToEveningDresses();
    }

    @Then("He opens first product on page in new window")
    public void heOpensFirstProductOnPage() {
        productPage = loginPage.open1stProductNewWindow();
    }

    @Then("He selects pink color")
    public void heSelectsPinkColor() {
        productPage.selectPinkColor();
    }

    @And("He selects L size")
    public void heSelectsLsize() {
        productPage.selectLsize();
    }

    @Then("He clicks Add to Cart button")
    public void heClicksAddToCartButton() {
        productPage.clickAddToCart();
    }

    @Then("He clicks Continue Shopping button")
    public void heClicksContinueShopping() {
        productPage.clickContinueShopping();
    }

    @When("He moves mouse over cart verifies size and color")
    public void heMovesMouseOverCartVerifiesSizeAndColor() {
        productPage.mouseOverCart();
        productPage.verifySizeAndColor();
    }

    @When("He removes product from cart verifies empty cart")
    public void heRemovesProductFromCartVerifiesEmptyCart() {
        productPage.removeProduct();
        productPage.verifyCartIsEmpty();
    }

    @Then("He closes new window")
    public void heClosesNewWindow() {
        closeWindowAndSwitchToOther();
    }

    @And("He prints cookies to console")
    public void hePrintsCookiesToConsole() {
        productPage.printCookies();
    }

    @Then("He quits")
    public void heQuits() {
        quitWebDriver();
    }
}
