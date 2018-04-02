package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 25.03.18.
 */
public class LinkedInChooseNewPassPage extends LinkedInBasePage {

    /**
     *Find the field new password
     */
    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPass;

    /**
     *Find the field retype new password
     */
    @FindBy(id = "new_password_again-newPassword-passwordReset")
    private WebElement retypeNewPass;

    /**
     *Find the Submit button
     */
    @FindBy(id = "reset")
    private WebElement submitButton;

    public LinkedInChooseNewPassPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *confirm that page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = newPass.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     *Enter and submit new password on SubmitNewwPass web page
     * @param newPassword - new password
     * @return new web page LinkedInResetPassSuccessPage(
     */
    public LinkedInResetPassSuccessPage submitNewPass(String newPassword) {
        newPass.sendKeys(newPassword);
        retypeNewPass.sendKeys(newPassword);
        waitTillElementIsClickable(submitButton).click();
        return new LinkedInResetPassSuccessPage(webDriver);
    }
}
