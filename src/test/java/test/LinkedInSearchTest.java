package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInBasePage;
import page.LinkedInHomePage;
import page.LinkedInLandingPage;
import page.LinkedInSearchPage;

import java.awt.*;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInSearchTest {

    WebDriver webDriver;

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
    public void basicSearchTest() throws InterruptedException {

        String searchWord = "hr";

        LinkedInLandingPage loginPage = new LinkedInLandingPage(webDriver);
        LinkedInHomePage homePage = loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");
        LinkedInSearchPage searchPage = homePage.searchByTerm(searchWord);
        List<String> results = searchPage.getResuls();

        Assert.assertEquals(results.size(), 10,
                "Expected size of results is not 10" );

        for (String result: results){
            Assert.assertTrue(result.toLowerCase().contains(searchWord),
                    "Search results does not contain HR in element" );
        }

    }

}
