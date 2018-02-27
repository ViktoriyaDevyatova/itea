import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vika on 27.02.18.
 */
public class LinkedInBasePage {

    WebDriver webDriver;
    WebElement userIcon;

    public LinkedInBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private void initElements (){
       userIcon = webDriver.findElement(By.id("profile-nav-item"));
       }

    public boolean isSignedIn (){
        initElements();
        waitTillElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

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

}
