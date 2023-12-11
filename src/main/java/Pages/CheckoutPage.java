package Pages;

import ElementLocators.CheckoutElement;
import Utility.DriverClass;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends DriverClass {

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    CheckoutElement checkoutElementObj = new CheckoutElement(driver);
    public void goToCart()
    {

        checkoutElementObj.goToCart().click();
    }
    public void checkout()
    {
        checkoutElementObj.confirmCheckout().click();
    }
    public void fillForm(String firstName, String lastName, String zipCode)
    {
        checkoutElementObj.firstName().sendKeys(firstName);
        checkoutElementObj.lastName().sendKeys(lastName);
        checkoutElementObj.zipCode().sendKeys(zipCode);
        checkoutElementObj.continueBtn().click();
    }

    public void finishButton()
    {

        checkoutElementObj.finishBtn().click();
    }

}
