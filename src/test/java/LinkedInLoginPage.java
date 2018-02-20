import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInLoginPage {

    WebDriver webDriver;

    public LinkedInLoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

     private WebElement emailField = webDriver.findElement(By.id("login-email"));
     private WebElement passwordField = webDriver.findElement(By.id("login-password"));
     private WebElement submitButton = webDriver.findElement(By.id("login-submit"));


    public void loginAs(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

}
