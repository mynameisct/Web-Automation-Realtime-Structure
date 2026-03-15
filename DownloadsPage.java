package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionDriver;

public class DownloadsPage {
    private WebDriver driver;
    private ActionDriver action;

    // Update this locator after inspecting the actual button in DevTools
    @FindBy(partialLinkText = "Downloads")
    private WebElement downloadLink;

    public DownloadsPage(WebDriver driver, ActionDriver action) {
        this.driver = driver;
        this.action = action;
        PageFactory.initElements(driver, this);
    }

    public void verifyDownloadPageTitle() {
        action.verifyTitle("Download best antivirus for pc | Net Protector Antivirus");
    }

    public void clickNpavDownload() {
        action.scrollToElement(downloadLink, "NPAV Setup Download Link");
        action.click(downloadLink, "NPAV Setup Download Link");
    }
}
