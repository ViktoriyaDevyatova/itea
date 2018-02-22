import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInSearch {

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
    public void basicSearchTest() throws InterruptedException, AWTException {


        LinkedInLoginPage loginPage = new LinkedInLoginPage(webDriver);
        loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        //search
        WebElement searchField = webDriver.findElement(By.xpath("//input[@placeholder='Search']"));
        WebElement clickButton = webDriver.findElement(By.xpath("//*[@type='search-icon']"));
        String searchWord = "hr";
        searchField.sendKeys(searchWord);
        clickButton.click();
        sleep(5000);

      //  WebElement listOfResults = webDriver.findElement(By.xpath("//ul[contains(@class, 'search-results__list list-style-none')]"));
       //listOfResults.findElement(By.tagName("li")).findElement(By.className("search-result search-result__occluded-item ember-view"));

        //search-result__info pt3 pb4 ph0
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        js.executeScript("window.scrollBy(0,250)", "");

        List<WebElement> listOfResults = webDriver.findElements(By.cssSelector("div[class=\"search-result__info pt3 pb4 ph0\"]"));
        System.out.println("how much results: " + listOfResults.size());

      Assert.assertEquals( listOfResults.size(), 4, "Results of the search do not contain HR" );

        for (WebElement result : listOfResults)   {
        Assert.assertTrue(result.getText().toLowerCase().contains(searchWord),"Search result does not contain HR");
                              // System.out.println("element: " + result.getText());
  }





        //HOMEWORK
        //check quantity of results -10 and all results contain HR




    }

}
