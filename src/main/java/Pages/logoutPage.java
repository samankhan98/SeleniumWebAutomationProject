package Pages;

import ElementLocators.logoutElement;
import Utility.DriverClass;
import org.openqa.selenium.WebDriver;

public class logoutPage extends DriverClass {

    public logoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    logoutElement logoutElementsObj = new logoutElement(driver);

    public void sideNavigate()
    {
        logoutElementsObj.sideNavigation().click();
    }
    public void confirmLogout()
    {
        logoutElementsObj.logoutButton().click();
    }

}
