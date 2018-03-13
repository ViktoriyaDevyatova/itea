package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.dumpStack;
import static java.lang.Thread.sleep;


/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInLandingPage extends LinkedInBasePage{

    //  WebDriver webDriver;

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement submitButton;




    public LinkedInLandingPage(WebDriver webDriver){
        super(webDriver);
       // this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public <T> T loginAs (String username, String password)throws InterruptedException {
        waitTillElementIsClickable(emailField, 5);
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        //if (submitButton.isDisplayed()){
          //  return (T) this;
        if (getPageTitle().equals("LinkedIn: Log In or Sign Up")){
            return (T) this;
        }
        else {return (T) PageFactory.initElements(webDriver,LinkedInHomePage.class);
        }

    }

//    public LinkedInSignInPage unsuccessfullLogin (String username, String password)throws InterruptedException {
//        waitTillElementIsClickable(emailField, 5);
//        emailField.sendKeys(username);
//        passwordField.sendKeys(password);
//        submitButton.click();
//        return new LinkedInSignInPage(webDriver);
//    }

}
