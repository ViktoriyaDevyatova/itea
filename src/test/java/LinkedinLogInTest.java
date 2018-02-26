
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 16.02.18.
 */
public class LinkedinLogInTest {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
           }


    @AfterClass
    public void afterClass(){

    }

    @BeforeMethod
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }

    @Test
    public void successfullyLogin () throws InterruptedException {

        //WebElement emailField = webDriver.findElement(By.xpath("//*[@id='login-email']");
        //WebElement password = webDriver.findElement(By.xpath("//*[@id='login-password']"));

        String initialPageTitle = webDriver.getTitle();
        String initialPageUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page name is not correct");

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement password = webDriver.findElement(By.id("login-password"));
        WebElement submitButton = webDriver.findElement(By.id("login-submit"));

        emailField.sendKeys("v.devyatova@ukr.net");
        password.sendKeys("linkedkurdo2106");
        submitButton.click();

        sleep(20000);

        WebElement userIcon = webDriver.findElement(By.id("profile-nav-item"));
        Assert.assertTrue(userIcon.isDisplayed(),"User icon was not found");
        Assert.assertNotEquals(webDriver.getTitle(), initialPageTitle, "Page title did not change after login");
        Assert.assertNotEquals(webDriver.getCurrentUrl(), initialPageUrl, "URL after login did not change");



        //webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);



       //String loginVerify = webDriver.findElement(By.xpath("//a[contains(@href, '/in/viktoria-devi-a5403115a/')]")).getAttribute("href");
       //Assert.assertEquals(loginVerify, "https://www.linkedin.com/in/viktoria-devi-a5403115a/");


      // WebElement loginVerify = webDriver.findElement(By.xpath("//div[@class='left-rail-container Elevation-2dp mb2']//a[text()='Добро пожаловать, Viktoria!']"));
      // Assert.assertTrue(loginVerify.isDisplayed(), "You are not loged in");


    }

    @Test
    public void negativeLogin () throws InterruptedException {

        //WebElement emailField = webDriver.findElement(By.xpath("//*[@id='login-email']");
        //WebElement password = webDriver.findElement(By.xpath("//*[@id='login-password']"));

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement password = webDriver.findElement(By.id("login-password"));
        WebElement submitButton = webDriver.findElement(By.id("login-submit"));

        emailField.sendKeys("test@ukr.net");
        password.sendKeys("123456");
        submitButton.click();

        sleep(20000);

        WebElement alertMessage = webDriver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

        Assert.assertTrue(alertMessage.isDisplayed(), "Message is absent");

        // String linkedName = webDriver.findElement(By.("ember2242")).getAttribute("href");
        // System.out.println("Welcome in LinkedIn" + linkedName);

        // Asserts.check(linkedName.contains("Viktoria Devi"), "It's not your account");


    }
}
