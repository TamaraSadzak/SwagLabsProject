package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String cartVerification = "YOUR CART";
    String AllItemsVerification = "PRODUCTS";
    int numberOfAllItems = 6;

    @Test
    public void VerifyCartEntry() {
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    cartPage = new CartPage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    cartPage.verifyCartEntry(cartVerification);

    }

    @Test
    public void VerifyCartToAllItems() {
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnShoopingCartButton();
    homePage.clickOnHamburgerMenu();
    homePage.clickOnAllItemsButton();
    homePage.verifyAllItemsPage(AllItemsVerification);

    }

    @Test
    public void VerifyAboutLink() {
        
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.clickOnHamburgerMenu();
    homePage.verifyAboutLink();

    }

    @Test
    public void NumberOfItemsHomePage() {

    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.numberOfProducts(numberOfAllItems);
   }
}

    

