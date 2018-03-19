package page;

import org.openqa.selenium.By;
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

    @FindBy(id = "session_key-login")
    private WebElement emailField;

    @FindBy(id = "session_password-login")
    private WebElement passwordField;

    @FindBy(id = "btn-primary")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='global-alert-queue']//strong[not(text()='')]")
    private WebElement alertMessage;

    public LinkedInLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean failedLogin (){
        waitTillElementIsClickable(alertMessage);
        return alertMessage.isDisplayed();
    }

    public String getEmailMessage (){
      return   webDriver.findElement(By.id("session_key-login-error")).getText();
    }

    public String getPassMessage (){
        return   webDriver.findElement(By.id("session_password-login-error")).getText();
    }





}


