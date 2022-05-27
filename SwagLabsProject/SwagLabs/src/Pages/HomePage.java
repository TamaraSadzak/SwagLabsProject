package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By menuButtonBy = By.xpath("//*[@id='react-burger-menu-btn']");
    By logoutButtonBy = By.xpath("//*[@id='logout_sidebar_link']");
    By homePageTittleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By shoopingCartBy = By.xpath("//*[@id='shopping_cart_container']/a");
    By AllItemsButtonBy = By.xpath("//*[@id='inventory_sidebar_link']");
    String expectedHref = "https://saucelabs.com/";
    By AboutButtonBy = By.xpath("//*[@id='about_sidebar_link']");
    By numberOfItemsBy = By.className("inventory_item");
    By addToCartButtonBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");

    public HomePage verifyAllItemsPage(String expectedText) {
        String actualTitle = readText(homePageTittleBy);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }

    public HomePage clickOnHamburgerMenu() {
        click(menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton() {
        click(logoutButtonBy);
        return this;
    }

    public HomePage clickOnShoopingCartButton() {
        click(shoopingCartBy);
        return this;
    }

    public HomePage clickOnAllItemsButton() {
        click(AllItemsButtonBy);
        return this;
    }

    public HomePage verifyAboutLink() {
        String actualTitle = readHref(AboutButtonBy);
        assertTextEquals(expectedHref, actualTitle);
        return this;
    }

    public HomePage numberOfProducts(int expectedNumberOfProducts) {
        int actualNumberOFProducts = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOFProducts);
        return this;
    }

    public HomePage clickOnAddToCartButton() {
        click(addToCartButtonBy);
        return this;
    }
}
