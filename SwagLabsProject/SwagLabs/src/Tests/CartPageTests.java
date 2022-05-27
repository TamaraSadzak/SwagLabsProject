package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;

public class CartPageTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String addedProduct = "Sauce Labs Backpack";
    String firstName = "Tamara";
    String lastName = "Sadzak";
    String postalCode = "22441";
    double itemTotal = 29.99;
    double tax = 2.40;
    double totalPrice = 32.39;

    @Test
    public void verifyAddedProduct() {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.clickOnAddToCartButton();
        homePage.clickOnShoopingCartButton();
        cartPage.verifyAddedProduct(addedProduct);
    }
    
    @Test
    public void validateTotalPriceIsDisplayedProperly() {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.clickOnAddToCartButton();
        homePage.clickOnShoopingCartButton();
        cartPage.verifyAddedProduct(addedProduct);
        cartPage.clickOnCheckoutButton();
        cartPage.enterYourInformation(firstName, lastName, postalCode);
        cartPage.totalPriceOfProduct(itemTotal, tax, totalPrice);
    }
}
