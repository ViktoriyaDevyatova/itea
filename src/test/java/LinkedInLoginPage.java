import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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

}
