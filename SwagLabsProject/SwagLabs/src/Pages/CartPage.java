package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By shoopingCartConfirmationBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By addedProductConfirmationBy = By.xpath("//*[@id='item_4_title_link']/div");
    By checkoutButtonBy = By.xpath("//*[@id='checkout']");
    By firstNameBy = By.xpath("//*[@id='first-name']");
    By lastNameBy = By.xpath("//*[@id='last-name']");
    By postalCodeBy = By.xpath("//*[@id='postal-code']");
    By continueButtonBy = By.xpath("//*[@id='continue']");

    public CartPage verifyCartEntry(String expectedText) {
        String actualTitle = readText(shoopingCartConfirmationBy);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }

    public CartPage verifyAddedProduct(String expectedText) {
        String actualTitle = readText(addedProductConfirmationBy);
        assertTextEquals(expectedText, actualTitle);
        return this;
    }

    public CartPage clickOnCheckoutButton() {
        click(checkoutButtonBy);
        return this;
    }

    public CartPage enterYourInformation(String firstName, String lastName, String postalCode ) {
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        click(continueButtonBy);
        return this;
    }

    public CartPage totalPriceOfProduct (double itemTotal, double tax, double totalPrice) {
        assertDoubleEquals(itemTotal, tax, totalPrice);
        return this;
    }
}
