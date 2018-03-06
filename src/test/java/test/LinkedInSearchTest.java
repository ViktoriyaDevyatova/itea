package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInSearchTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


    @Test
    public void basicSearchTest() throws InterruptedException, AWTException {


        LinkedInLandingPage loginPage = new LinkedInLandingPage(webDriver);
        loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        //search
        WebElement searchField = webDriver.findElement(By.xpath("//input[@placeholder='Search']"));
        WebElement clickButton = webDriver.findElement(By.xpath("//*[@type='search-icon']"));
        String searchWord = "hr";
        searchField.sendKeys(searchWord);
        clickButton.click();

        sleep(5000);

        List<WebElement> listOfResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));

        Assert.assertEquals(listOfResults.size(), 10, "Expected size of results is not 10" );

        for (WebElement element:  listOfResults){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
            String elementText = element.getText().toLowerCase();
            Assert.assertTrue(elementText.contains(searchWord),
                    "Search result does not contain HR in element: " + element.getText());
        }

    }
}
