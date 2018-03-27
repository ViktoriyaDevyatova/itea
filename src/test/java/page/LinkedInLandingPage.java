package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInLandingPage extends LinkedInBasePage{

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@class= 'link-forgot-password']")
    private WebElement forgotPassword;


    public LinkedInLandingPage(WebDriver webDriver){
        super(webDriver);
       // this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public <T> T loginAs(String username, String password) throws InterruptedException {
        waitTillElementIsClickable(emailField, 5);
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        if (getCurrentURL().contains("/login-submit")){
            return (T) new LinkedInLoginPage(webDriver);
        }
        if (getCurrentURL().contains("/feed")){
            return (T) new LinkedInHomePage(webDriver);
        }
        else {
            return (T) this;
        }
    }

    public boolean forgotPasswordButtonIsPresent() {
        return forgotPassword.isDisplayed();
    }


    public LinkedInRequestPassResetPage forgotPassLinkClick() {
        forgotPassword.click();
        return new LinkedInRequestPassResetPage(webDriver);
    }

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
