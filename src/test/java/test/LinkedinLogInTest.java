package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedInLoginPage;
import page.LinkedInHomePage;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 16.02.18.
 */
public class LinkedinLogInTest {

    WebDriver webDriver;
    LinkedInLandingPage landingPage;
    String initialPageTitle;
    String initialPageUrl;

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
        landingPage = new LinkedInLandingPage(webDriver);
        initialPageTitle = landingPage.getPageTitle();
        initialPageUrl = landingPage.getCurrentURL();
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }

    @Test
    public void successfullyLogin () throws InterruptedException {

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                                        "Login page name is not correct");

        LinkedInHomePage homePage = landingPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        Assert.assertTrue(homePage.isSignedIn(),"User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                                        "Page title did not change after login");
        Assert.assertNotEquals(homePage.getCurrentURL(), initialPageUrl,
                                        "URL after login did not change");

    }

    @Test
    public void negativeLogin () throws InterruptedException {

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page name is not correct");

        LinkedInLoginPage signInPage = landingPage.loginAs("test@ukr.net", "123456");

        Assert.assertTrue(signInPage.failedLogin(),"User is signed in");

        Assert.assertNotEquals(signInPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(signInPage.getCurrentURL(), initialPageUrl,
                "URL after login did not change");

    }
}
