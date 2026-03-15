package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DownloadsPage;
import pages.HomePage;
import utils.ActionDriver;

public class DownloadPageTest extends BaseTest {

    @Test
    public void testDownloadPageNavigation() {
        ActionDriver action = new ActionDriver(driver, Integer.parseInt(config.getProperty("timeout","10")));
        HomePage home = new HomePage(driver, action);
        home.clickDownload();

        DownloadsPage download = new DownloadsPage(driver, action);
        download.verifyDownloadPageTitle();
        download.clickNpavDownload();
    }
}
