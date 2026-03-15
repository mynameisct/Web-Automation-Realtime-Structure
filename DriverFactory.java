package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{

    public static WebDriver driver;

    //Get driver instance based on browser name

    public static WebDriver getDriver(String browser)
    {

        if(driver==null)
        {
            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new RuntimeException("Unsupported browser" + browser);
            }
        }

        return driver;
    }

    public static void quitDriver()
    {
        if(driver!=null)
        {
            driver.quit();
            driver=null;
        }
    }
}
