package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    // Constructor to initialize driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Generic click
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // Generic type
    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Check visibility
    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    // Page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}
