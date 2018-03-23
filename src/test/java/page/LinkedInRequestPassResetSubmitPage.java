package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInRequestPassResetSubmitPage extends LinkedInBasePage {


    @FindBy(xpath = "//a[@class= 'status-link btn-resend-link']")
    private WebElement resendLinkButton;


    public LinkedInRequestPassResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = resendLinkButton.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }
}
