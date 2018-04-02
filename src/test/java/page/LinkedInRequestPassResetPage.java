package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInRequestPassResetPage extends LinkedInBasePage {

    /**
     *Find the email field on the web page
     */
    @FindBy(id = "userName-requestPasswordReset")
    private WebElement emailField;

    /**
     *Find the Submit button on the web page
     */
    @FindBy(id = "btnSubmitResetRequest")
    private WebElement submitButton;


    public LinkedInRequestPassResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @param email - user email to change password
     * @return new web page LinkedInRequestPassResetSubmitPage for pass changing
     */
    public LinkedInRequestPassResetSubmitPage submitEmail(String email) {
        emailField.sendKeys(email);
        submitButton.click();
        return new LinkedInRequestPassResetSubmitPage(webDriver);
    }

    /**
     *confirm if the page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = emailField.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }
}
