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

    /**
     *Finds the successfull pass change message on the web page
     */
    @FindBy(xpath = "//div[@class= 'flow-login-content']")
    private WebElement successfullPassResetMessage;

    /**
     *Finds the Fo to Home button on the web page
     */
    @FindBy(xpath = "//a[@class= 'btn-secondary-transparent']")
    private WebElement goToHomeButton;

    public LinkedInResetPassSuccessPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *confirm if the page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = successfullPassResetMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     * Navigates to home page
     * @return home page
     */
    public LinkedInHomePage navigateToHomePage() {
        goToHomeButton.click();
        return new LinkedInHomePage(webDriver);
    }
}
