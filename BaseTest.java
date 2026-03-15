package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ActionDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config;
    protected ActionDriver actionDriver;

    @BeforeClass
    public void setUp() throws IOException {
        // Load config.properties
        config = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties"
        );
        config.load(fis);

        String browser = config.getProperty("browser", "chrome");
        String baseUrl = config.getProperty("baseUrl", "https://npav.net/");

        // Initialize driver via DriverFactory
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Initialize ActionDriver
        actionDriver = new ActionDriver(driver, 10);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
