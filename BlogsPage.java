package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogsPage {
    private WebDriver driver;

    // PageFactory locator for Blogs link
    @FindBy(xpath = "//a[normalize-space()='Blogs']")
    private WebElement blogsLink;

    // Constructor initializes PageFactory
    public BlogsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action method to click Blogs link
    public void clickBlogsLink() {
        blogsLink.click();
    }
}
