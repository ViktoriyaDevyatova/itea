package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLandingPage;

/**
 * Created by Vika on 16.03.18.
 */
public class LinkedInBaseTest {

    WebDriver webDriver;
    LinkedInLandingPage landingPage;

    @BeforeMethod
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.linkedin.com/");
        landingPage = new LinkedInLandingPage(webDriver);
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


}
