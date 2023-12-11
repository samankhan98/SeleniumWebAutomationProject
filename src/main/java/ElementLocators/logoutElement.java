package ElementLocators;

import Utility.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logoutElement extends DriverClass {
    public logoutElement(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement sideNavigation()
    {
        return driver.findElement(By.xpath(" //button[@id='react-burger-menu-btn']"));
    }
    public WebElement logoutButton()
    {
        return driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
    }
}
