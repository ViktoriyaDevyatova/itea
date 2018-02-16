
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Vika on 16.02.18.
 */
public class LinkedinLogIn {

    @Test
    public void successfullyLogin ()  {

        WebDriver webDriver = new FirefoxDriver();

        webDriver.navigate().to("https://www.linkedin.com");
        //WebElement emailField = webDriver.findElement(By.xpath("//*[@id='login-email']");
        //WebElement password = webDriver.findElement(By.xpath("//*[@id='login-password']"));

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement password = webDriver.findElement(By.id("login-password"));
        WebElement submitButton = webDriver.findElement(By.id("login-submit"));

        emailField.sendKeys("v.devyatova@ukr.net");
        password.sendKeys("linkedkurdo2106");
        submitButton.click();

       // String linkedName = webDriver.findElement(By.("ember2242")).getAttribute("href");
       // System.out.println("Welcome in LinkedIn" + linkedName);

       // Asserts.check(linkedName.contains("Viktoria Devi"), "It's not your account");


    }

    @Test
    public void negativeLogin ()  {

        WebDriver webDriver = new FirefoxDriver();

        webDriver.navigate().to("https://www.linkedin.com");
        //WebElement emailField = webDriver.findElement(By.xpath("//*[@id='login-email']");
        //WebElement password = webDriver.findElement(By.xpath("//*[@id='login-password']"));

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement password = webDriver.findElement(By.id("login-password"));
        WebElement submitButton = webDriver.findElement(By.id("login-submit"));

        emailField.sendKeys("test@ukr.net");
        password.sendKeys("123456");
        submitButton.click();

        WebElement alertMessage = webDriver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

        Assert.assertTrue(alertMessage.isDisplayed(), "Message is absent");

        // String linkedName = webDriver.findElement(By.("ember2242")).getAttribute("href");
        // System.out.println("Welcome in LinkedIn" + linkedName);

        // Asserts.check(linkedName.contains("Viktoria Devi"), "It's not your account");


    }
}
