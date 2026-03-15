package utils;

import com.aventstack.extentreports.Status;
import listeners.TestListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ActionDriver {
    private WebDriver driver;
    private WebDriverWait wait;

    public ActionDriver(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }


    public void click(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            TestListener.getTest().log(Status.INFO, "Clicked on: " + elementName);
        } catch (Exception e) {
            TestListener.getTest().log(Status.FAIL, "Click failed on: " + elementName);
            Assert.fail("Click failed on: " + elementName, e);
        }
    }

    public void type(WebElement element, String value, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(value);
            TestListener.getTest().log(Status.INFO, "Typed '" + value + "' into: " + elementName);
        } catch (Exception e) {
            TestListener.getTest().log(Status.FAIL, "Typing failed on: " + elementName);
            Assert.fail("Typing failed on: " + elementName, e);
        }
    }

    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            TestListener.getTest().log(Status.PASS, "Verified page title: " + actualTitle);
        } else {
            TestListener.getTest().log(Status.FAIL,
                    "Page title mismatch! Expected [" + expectedTitle + "] but found [" + actualTitle + "]");
            Assert.fail("Page title mismatch! expected [" + expectedTitle + "] but found [" + actualTitle + "]");
        }
    }

    public void scrollToElement(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            TestListener.getTest().log(Status.INFO, "Scrolled to: " + elementName);
        } catch (Exception e) {
            TestListener.getTest().log(Status.FAIL, "Scroll failed on: " + elementName);
            Assert.fail("Scroll failed on: " + elementName, e);
        }
    }

    public void getText(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText();
            TestListener.getTest().log(Status.INFO, "Captured text from " + elementName + ": " + text);
        } catch (Exception e) {
            TestListener.getTest().log(Status.FAIL, "Failed to capture text from: " + elementName);
            Assert.fail("Failed to capture text from: " + elementName, e);
        }
    }

    public void navigateTo(String url) {
        try {
            driver.navigate().to(url);
            TestListener.getTest().log(Status.INFO, "Navigated to URL: " + url);
        } catch (Exception e) {
            TestListener.getTest().log(Status.FAIL, "Navigation failed to URL: " + url);
            Assert.fail("Navigation failed to URL: " + url, e);
        }
    }
}
