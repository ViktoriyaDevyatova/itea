package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInBasePage;
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
    WebElement searchField;
    WebElement clickButton;
    String searchWord;
    //List<WebElement> listOfResults;
    LinkedInLandingPage loginPage;
    LinkedInBasePage linkedInBasePage;
    LinkedInSearchPage linkedInSearchPage;


    @BeforeMethod
    public void beforeTest()throws InterruptedException, AWTException{
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.linkedin.com/");
        loginPage = new LinkedInLandingPage(webDriver);
        loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");
        searchField = webDriver.findElement(By.xpath("//input[@placeholder='Search']"));
        clickButton = webDriver.findElement(By.xpath("//*[@type='search-icon']"));
        searchWord = "hr";
        //linkedInBasePage = new LinkedInBasePage(webDriver);

    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


    @Test
    public void basicSearchTest() throws InterruptedException {

        searchField.sendKeys(searchWord);
        clickButton.click();

        linkedInSearchPage = new LinkedInSearchPage(webDriver);
        linkedInSearchPage.waitTitleChange();

        sleep(500);

        //listOfResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));

        Assert.assertEquals(linkedInSearchPage.listOfResults.size(), 10,
                                                "Expected size of results is not 10" );

        Assert.assertTrue(linkedInSearchPage.checkOfSearchResult().contains(searchWord),
                "Search result does not contain HR in element");

//        for (WebElement element:  linkedInSearchPage.listOfResults){
//            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
//            String elementText = element.getText().toLowerCase();
//            Assert.assertTrue(elementText.contains(searchWord),
//                    "Search result does not contain HR in element: " + element.getText());
//        }

    }

}
