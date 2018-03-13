package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vika on 27.02.18.
 */
public class LinkedInBasePage {

    WebDriver webDriver;

//    @FindBy(id = "profile-nav-item")
//    private WebElement userIcon;

    public LinkedInBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
    }


//    public boolean isSignedIn (){
//        waitTillElementIsClickable(userIcon);
//        return userIcon.isDisplayed();
//    }

    public String getPageTitle (){
        return webDriver.getTitle();
    }

    public String getCurrentURL (){
        return  webDriver.getCurrentUrl();
    }

    public void waitTillElementIsClickable (WebElement webElement){
        waitTillElementIsClickable(webElement,5);
    }

    public void waitTillElementIsClickable (WebElement webElement, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitTillElementIsVisible (WebElement webElement, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
   }
