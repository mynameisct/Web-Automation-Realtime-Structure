package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ActionDriver;

public class HomePageTest extends BaseTest {

    @Test
    public void testBuyNowNavigation() {
        ActionDriver action = new ActionDriver(driver, Integer.parseInt(config.getProperty("timeout","10")));
        HomePage home = new HomePage(driver, action);
        home.clickBuyNow();
        action.verifyTitle("Buy Now | Net Protector Antivirus");
    }
}
