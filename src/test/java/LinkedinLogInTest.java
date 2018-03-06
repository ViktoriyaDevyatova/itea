
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

        LinkedInLoginPage loginPage = new LinkedInLoginPage(webDriver);

        String initialPageTitle = loginPage.getPageTitle();
        String initialPageUrl = loginPage.getCurrentURL();
        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                                        "Login page name is not correct");

       LinkedInBasePage homePage = loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        Assert.assertTrue(homePage.isSignedIn(),"User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                                        "Page title did not change after login");
        Assert.assertNotEquals(homePage.getCurrentURL(), initialPageUrl,
                                        "URL after login did not change");

    }

    @Test
    public void negativeLogin () throws InterruptedException {

        LinkedInLoginPage loginPage = new LinkedInLoginPage(webDriver);

        LinkedInSignInPage unsuccessfullSignInPage = loginPage.unsuccessfullLogin("test@ukr.net", "123456");
        System.out.println("Login is unsuccessfull");

//        WebElement emailField = webDriver.findElement(By.id("login-email"));
//        WebElement password = webDriver.findElement(By.id("login-password"));
//        WebElement submitButton = webDriver.findElement(By.id("login-submit"));

//        emailField.sendKeys("test@ukr.net");
//        password.sendKeys("123456");
//        submitButton.click();
//
//        sleep(20000);

       // WebElement alertMessage = webDriver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));

//        Assert.assertTrue(signInPage.alertMessage(), "Message is absent");

    }
}
