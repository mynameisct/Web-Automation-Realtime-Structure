package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaPage {
    private WebDriver driver;

    // Locators for social media icons
    @FindBy(xpath = "//a[contains(@href,'facebook.com')]")
    private WebElement facebookIcon;

    @FindBy(xpath = "//a[@title='Follow NPAV on X (formerly Twitter)']//i[@class='fa-brands fa-x-twitter']")
    private WebElement xIcon;

    @FindBy(xpath = "//a[@title='Follow NPAV on Instagram']//i[@class='bx bxl-instagram']")
    private WebElement instagramIcon;

    @FindBy(xpath = "//a[@title='Connect with NPAV on LinkedIn']")
    private WebElement linkedinIcon;

    @FindBy(xpath = "//a[@title='Subscribe to NPAV on YouTube']//i[@class='bx bxl-youtube']")
    private WebElement youtubeIcon;


    public SocialMediaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action methods
    public void clickFacebook()
    {
        facebookIcon.click();
    }

    public void clickX()
    {
        xIcon.click();
    }

    public void clickInstagram()
    {
        instagramIcon.click();
    }

    public void clickLinkedIn()
    {
        linkedinIcon.click();
    }

    public void clickYouTube()
    {
        youtubeIcon.click();
    }
}