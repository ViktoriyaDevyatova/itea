import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public void basicSearchTest() throws InterruptedException {


        LinkedInLoginPage loginPage = new LinkedInLoginPage(webDriver);
        loginPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        //search
        //WebElement searchField = webDriver.findElement(By.xpath("//input[@placeholder='Search']"));
        //WebElement clickButton = webDriver.findElement(By.xpath("//*[@type='search-icon']"));
        //searchField.sendKeys("hr");
        //clickButton.click();

        //div[contains(@class, 'search-result-person')]


        //HOMEWORK
        //check quantity of results -10 and all results contain HR




    }

}
