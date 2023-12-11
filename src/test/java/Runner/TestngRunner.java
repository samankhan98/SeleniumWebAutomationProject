package Runner;


import Pages.CheckoutPage;
import Pages.loginPage;
import Pages.logoutPage;
import Utility.DriverClass;
import Utility.Listeners.AllureTestListener;
import Utility.PropertyFileReader;
import Utility.Screenshot;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@Listeners(AllureTestListener.class)
public class TestngRunner extends DriverClass {
    String destination = System.getProperty("user.dir") +"/allure-results";
    //   String destination = System.getProperty("user.dir") ;

    static String timestamp = new SimpleDateFormat("MM-dd-yyyy-[HH-mm-ss]").format(new Date());
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    DriverClass driverClass = new DriverClass();
    Screenshot screenshot = new Screenshot();
    loginPage loginPageObj;
    logoutPage logoutPageObj;
    CheckoutPage checkoutPageObj;

    @BeforeSuite
    public void StatingWebApplication()
    {
        driverClass.setup();
        System.out.println("--------------App Launched--------------");
    }

    @BeforeTest
    public void ObjectInitilization()
    {
        loginPageObj =new loginPage(driver);
        checkoutPageObj = new CheckoutPage(driver);
        logoutPageObj = new logoutPage(driver);
        System.out.println("Object");
    }
    @Epic("Login")
    @Story("UnSuccessful Login")
    @Description("Enter Login Without Credentials")
    @Test (priority = 0)
    public void enterLoginWithoutCredentials()
    {
        System.out.println("Entering Credentials ");
    }
    @Epic("Login")
    @Story("UnSuccessful Login")
    @Description(" Login Without Credentials")
    @Test (priority = 1, description = "Login UnSuccessful")
    public void loginUnSuccessful()
    {
        loginPageObj.loginButton();
    }

    @Epic("Login")
    @Story("Successful Login")
    @Description("Enter Login  Valid Credentials")
    @Test (priority = 2)
    public void enterLoginCredentials()
    {
        System.out.println("Entering Credentials ");
        loginPageObj.clearLoginCredentials();
        loginPageObj.loginCredentials(propertyFileReader.properties.getProperty("userName"),"secret_sauce");
        System.out.println("Credentials Entered");
    }
    @Epic("Login")
    @Story("Successful Login")
    @Description(" Login With Credentials")
    @Test (priority = 3, description = "Login Successful")
    public void loginSuccessful()
    {
        loginPageObj.loginButton();
    }
    @Epic("Checkout")
    @Story("Go to Cart")
    @Description("Go to Cart")
    @Test (priority = 4,description = "Go to Cart")
    public void goToCart()
    {
        checkoutPageObj.goToCart();
    }
    @Epic("Checkout")
    @Story("Checkout for Payment")
    @Description("Checkout")
    @Test (priority = 5, description = "Checkout")
    public void Checkout()
    {
        checkoutPageObj.checkout();
    }

    @Epic("Checkout")
    @Story("Fill Personal Detail Form")
    @Description("Fill Personal Detail Form")
    @Test (priority = 6, description = "Fill Personal Detail Form")
    public void PersonalDetailForm()
    {
        checkoutPageObj.fillForm(propertyFileReader.properties.getProperty("firstName"),
                propertyFileReader.properties.getProperty("lastName"),
                propertyFileReader.properties.getProperty("ZipCode") );
    }
    @Epic("Checkout")
    @Story("Confirm Order")
    @Description("Confirm Order")
    @Test (priority = 7, description = "Confirm Order")
    public void confirmOrder()
    {
        checkoutPageObj.finishButton();
    }

    @Epic("Logout")
    @Story("Go to Sidebar Navigation")
    @Description("Go to Sidebar Navigation")
    @Test (priority = 8, description = " Go to Sidebar Navigation")
    public void goToSideNavigation()
    {
        logoutPageObj.sideNavigate();
    }

    @Epic("Logout")
    @Story("Logout Successful")
    @Description("Logout Successful")
    @Test (priority = 9, description = "Logout")
    public void logoutSuccessful()
    {
        logoutPageObj.confirmLogout();
    }


    @AfterMethod
    public void Screenshot()
    {
        screenshot.takeScreenshot(driver);
    }
    @BeforeMethod
    public void Screenshot2()
    {
        screenshot.takeScreenshot(driver);
    }
    @AfterTest
    public void closing()
    {
        driverClass.Quit();
    }

    @AfterSuite
    public void Ending()
    {

        File file = new File(destination);

        // Create an object of the File class
        // Replace the file path with path of the directory
        File rename = new File(destination+"_"+timestamp);

        // store the return value of renameTo() method in
        // flag
        boolean flag = file.renameTo(rename);

        // if renameTo() return true then if block is
        // executed
        if (flag == true) {
            System.out.println("File Successfully Rename");
        }
        // if renameTo() return false then else block is
        // executed
        else {
            System.out.println("Operation Failed");
        }
        System.out.println("--------------App Closed Successfully--------------");
    }
}
