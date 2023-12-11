package ElementLocators;

import Utility.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginElement extends DriverClass {

    public loginElement(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement userName()
    {
        return driver.findElement(By.xpath("//input[@id='user-name']"));
    }
    public WebElement password()
    {
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement loginButton()
    {
        return driver.findElement(By.xpath("//input[@id='login-button']"));
    }
    public WebElement closePopup()
    {
        return driver.findElement(By.xpath("//button[@class='error-button']/*[1]"));
    }
}
