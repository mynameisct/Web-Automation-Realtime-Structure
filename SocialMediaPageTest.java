package test;

import base.BaseTest;
import pages.SocialMediaPage;
import listeners.TestListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SocialMediaPageTest extends BaseTest {
    private SocialMediaPage socialPage;
    private String parentWindow;

    @BeforeClass
    public void setUpPage() {
        socialPage = new SocialMediaPage(driver);
        parentWindow = driver.getWindowHandle();
    }

    @Test
    public void verifySocialMediaNavigation() {
        SoftAssert softAssert = new SoftAssert();

        // Facebook
        TestListener.getTest().info("Clicking Facebook icon");
        socialPage.clickFacebook();
        switchToNewWindow();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/npav.net/", "Facebook URL mismatch");
        TestListener.getTest().info("Facebook navigation checked");
        closeAndReturn();

        // X
        TestListener.getTest().info("Clicking X icon");
        socialPage.clickX();
        switchToNewWindow();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://x.com/npavnet", "X URL mismatch");
        TestListener.getTest().info("X navigation checked");
        closeAndReturn();

        // Instagram
        TestListener.getTest().info("Clicking Instagram icon");
        socialPage.clickInstagram();
        switchToNewWindow();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.instagram.com/netprotector/", "Instagram URL mismatch");
        TestListener.getTest().info("Instagram navigation checked");
        closeAndReturn();

        // LinkedIn
        TestListener.getTest().info("Clicking LinkedIn icon");
        socialPage.clickLinkedIn();
        switchToNewWindow();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/netprotector/", "LinkedIn URL mismatch");
        TestListener.getTest().info("LinkedIn navigation checked");
        closeAndReturn();

        // YouTube
        TestListener.getTest().info("Clicking YouTube icon");
        socialPage.clickYouTube();
        switchToNewWindow();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/@npavnet", "YouTube URL mismatch");
        TestListener.getTest().info("YouTube navigation checked");
        closeAndReturn();

        // Collate results
        softAssert.assertAll();
        TestListener.getTest().pass("All social media navigations verified (soft assertions)");
    }

    // Utility methods
    private void switchToNewWindow() {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    private void closeAndReturn() {
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
