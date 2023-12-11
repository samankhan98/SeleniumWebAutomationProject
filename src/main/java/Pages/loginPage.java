package Pages;

import ElementLocators.loginElement;
import Utility.DriverClass;
import org.openqa.selenium.WebDriver;

public class loginPage extends DriverClass {

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    loginElement loginElementsObj = new loginElement(driver);

    public void loginCredentials(String username, String password)
    {
        loginElementsObj.userName().sendKeys(username);
        loginElementsObj.password().sendKeys(password);
    }
    public void clearLoginCredentials()
    {
        loginElementsObj.closePopup().click();
        loginElementsObj.userName().clear();
        loginElementsObj.password().clear();

    }

    public void loginButton()
    {
        loginElementsObj.loginButton().click();
    }
}
