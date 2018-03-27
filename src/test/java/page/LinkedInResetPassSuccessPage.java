package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 25.03.18.
 */
public class LinkedInResetPassSuccessPage extends  LinkedInBasePage {

    @FindBy(xpath = "//div[@class= 'flow-login-content']")
    private WebElement successfullPassResetMessage;

    @FindBy(xpath = "//a[@class= 'btn-secondary-transparent']")
    private WebElement goToHomeButton;

    public LinkedInResetPassSuccessPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = successfullPassResetMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    public LinkedInHomePage navigateToHomePage() {
        goToHomeButton.click();
        return new LinkedInHomePage(webDriver);
    }
}
