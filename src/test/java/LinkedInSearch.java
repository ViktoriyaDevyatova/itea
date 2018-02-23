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

        List<WebElement> listOfResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
      //  int jj = listOfResults.size();
//        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        js.executeScript("window.scrollBy(0,250)", "");


       // List<WebElement> listOfResults = webDriver.findElements(By.cssSelector("div[class=\"search-result__info pt3 pb4 ph0\"]"));
        System.out.println("how much results: " + listOfResults.size());
        Assert.assertEquals(listOfResults.size(), 10, "Results of the search do not contain HR" );

        for (int i =1; i < listOfResults.size(); i++){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", listOfResults.get(i));
            String cardTitle = webDriver.findElement(By.xpath("//li[contains(@class, 'search-result__occluded-item')]["+i+"]//span[contains(@class, 'actor-name')]")).getText();
            Assert.assertTrue(cardTitle.toLowerCase().contains(searchWord),"Search result does not contain HR in:" + Integer.toString(i));
            System.out.println(cardTitle);

        }







    }

}
