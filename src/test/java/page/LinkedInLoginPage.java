package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;

/**
 * Created by Vika on 01.03.18.
 */
public class LinkedInLoginPage extends LinkedInBasePage{

    /**
     *Find the email field on the web page
     */
    @FindBy(id = "session_key-login")
    private WebElement emailField;

    /**
     *Find the password field on the web page
     */
    @FindBy(id = "session_password-login")
    private WebElement passwordField;

    /**
     *Find the Submit button on the web page
     */
    @FindBy(id = "btn-primary")
    private WebElement submitButton;

    /**
     *Find the message about incorrect credentials
     */
    @FindBy(xpath = "//div[@id='global-alert-queue']//strong[not(text()='')]")
    private WebElement alertMessage;

    public LinkedInLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *Verifies if the login was failed
     */
    public boolean failedLogin (){
        waitTillElementIsClickable(alertMessage);
        return alertMessage.isDisplayed();
    }

    /**
     *Verifies the alert message because of incorrect email
     */
    public String getEmailMessage (){
      return   webDriver.findElement(By.id("session_key-login-error")).getText();
    }

    /**
     *Verifies the alert message because of incorrect password
     */
    public String getPassMessage (){
        return   webDriver.findElement(By.id("session_password-login-error")).getText();
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


