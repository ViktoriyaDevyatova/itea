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

    /**
     *Find the email field on the web page
     */
    @FindBy(id = "login-email")
    private WebElement emailField;

    /**
     *Find the password field on the web page
     */
    @FindBy(id = "login-password")
    private WebElement passwordField;

    /**
     *Find the Submit button on the web page
     */
    @FindBy(id = "login-submit")
    private WebElement submitButton;

    /**
     *Finds the Forgot password link on the web page
     */
    @FindBy(xpath = "//a[@class= 'link-forgot-password']")
    private WebElement forgotPassword;


    public LinkedInLandingPage(WebDriver webDriver){
        super(webDriver);
       // this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Enters user email and password and verifies navigeted webpage
     * @param username - user email to login
     * @param password - user password to login
     * @param <T> - generic type (allows to return different types)
     * @return - new web page according to entered credentials
     * (LinkedInLoginPage - incorrect credentials, LinkedInHomePage - correct credentials)
     * @throws InterruptedException
     */
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

    /**
     *Verifies if the Forgot password link is present on the web page
     */
    public boolean forgotPasswordButtonIsPresent() {
        return forgotPassword.isDisplayed();
    }


    /**
     *Click to the button Forgot Password
     * @return new web page LinkedInRequestPassResetPage
     */
     public LinkedInRequestPassResetPage forgotPassLinkClick() {
        forgotPassword.click();
        return new LinkedInRequestPassResetPage(webDriver); /**
     * Get the title of the current web page
     * @return title of the web page
     */
    }

    /**
     *confirms if the page is loaded
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
