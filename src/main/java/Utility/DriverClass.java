package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass
{
    public static WebDriver driver;
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    public void setup()
    {
        // Webdriver manager for chrome extension
        WebDriverManager.chromedriver().setup();
        // open Chrome
        driver = new ChromeDriver();
        // Url of Webpage
        String baseUrl = propertyFileReader.properties.getProperty("BaseUrl");
        // Redirect to URL
        driver.get(baseUrl);
        // Maximize Chrome
        driver.manage().window().maximize();

    }
    public static void Quit()
    {
     //   driver.close();
        driver.quit();

    }
}
