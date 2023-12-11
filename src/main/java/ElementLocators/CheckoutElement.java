package ElementLocators;

import Utility.DriverClass;
import Utility.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutElement extends DriverClass {


    PropertyFileReader propertyFileReaderObj =new PropertyFileReader();
    public CheckoutElement(WebDriver driver)
    {
        this.driver = driver;
    }

    Long time= Long.valueOf(propertyFileReaderObj.properties.getProperty("webExplicit"));
    WebDriverWait wait = new WebDriverWait(driver,time);
    public WebElement goToCart()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='shopping_cart_link']")));
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }
    public WebElement confirmCheckout()
    {
        return driver.findElement(By.xpath("//button[@id='checkout']"));
    }
    public WebElement firstName()
    {
        return driver.findElement(By.xpath("//input[@id='first-name']"));
    }
    public WebElement lastName()
    {
        return driver.findElement(By.xpath("//input[@id='last-name']"));
    }
    public WebElement zipCode()
    {
        return driver.findElement(By.xpath("//input[@id='postal-code']"));
    }
    public WebElement continueBtn()
    {
        return driver.findElement(By.xpath("//input[@id='continue']"));
    }
    public WebElement finishBtn()
    {
        By finish = By.xpath("//button[@id='finish']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(finish));

        return driver.findElement(finish);
    }

}
