package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionDriver;

public class HomePage {
    private WebDriver driver;
    private ActionDriver action;

    @FindBy(xpath = "//a[contains(text(),'Download')]")
    private WebElement downloadLink;

    @FindBy(linkText = "Contact Us")
    private WebElement contactLink;

    @FindBy(linkText = "Buy Now")
    private WebElement buyNowLink;

    public HomePage(WebDriver driver, ActionDriver action) {
        this.driver = driver;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    public void clickDownload() {
        action.click(downloadLink, "Download Link");
    }

    public void goToContact() {
        action.click(contactLink, "Contact Link");
        // Switch to new tab/window if Contact opens separately
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public void clickBuyNow() {
        action.click(buyNowLink, "Buy Now Link");
    }
}
