package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 25.03.18.
 */
public class LinkedInResetPass extends LinkedInBasePage {

    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPass;

    @FindBy(id = "new_password_again-newPassword-passwordReset")
    private WebElement retypeNewPass;

    @FindBy(id = "reset")
    private WebElement submitButton;

    public LinkedInResetPass(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = newPass.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    public LinkedINResetPassSubmit resetPassSubmit(String newPassword) {
        newPass.sendKeys(newPassword);
        retypeNewPass.sendKeys(newPassword);
        submitButton.click();
        return new LinkedINResetPassSubmit(webDriver);
    }
}