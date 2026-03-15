package test;

import base.BaseTest;
import pages.BlogsPage;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class BlogsPageTest extends BaseTest {
    private BlogsPage blogsPage;
    private String parentWindow;

    @BeforeClass
    public void setUpPage() {
        blogsPage = new BlogsPage(driver);
    }

    @Test
    public void verifyBlogsPageTitleInNewTab() {
        TestListener.getTest().info("Storing parent window handle");
        parentWindow = driver.getWindowHandle();

        TestListener.getTest().info("Clicking Blogs link");
        blogsPage.clickBlogsLink();

        TestListener.getTest().info("Switching to new window");
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                TestListener.getTest().info("Switched to new window: " + window);
                break;
            }
        }

        TestListener.getTest().info("Verifying page title");
        String expectedTitle = "Net Protector Antivirus – Download Best Antivirus for PC & Mobiles";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");
        TestListener.getTest().pass("Title verified successfully");

        TestListener.getTest().info("Closing new tab and switching back");
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
