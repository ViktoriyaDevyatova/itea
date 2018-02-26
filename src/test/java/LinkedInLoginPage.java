import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInLoginPage {

    WebDriver webDriver;

    public LinkedInLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

     private WebElement emailField;
     private WebElement passwordField;
     private WebElement submitButton;

     private void initElements()  {

         emailField = webDriver.findElement(By.id("login-email"));
         waitTillElementIsClickable(emailField, 5);
         passwordField = webDriver.findElement(By.id("login-password"));
         submitButton = webDriver.findElement(By.id("login-submit"));
     }


    public void loginAs (String username, String password)throws InterruptedException {
         initElements();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        sleep(5000);
    }

    public void waitTillElementIsClickable (WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitTillElementIsClickable (WebElement webElement, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));



    }

}
