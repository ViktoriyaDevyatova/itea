package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedInLandingPage;

/**
 * Created by Vika on 16.03.18.
 */
public class LinkedInBaseTest {

    WebDriver webDriver;
    LinkedInLandingPage landingPage;


    //homework - update with switchcase + additional paremeter - URL ua.linkedin.com + 2 xml files: 1st with firefox and www.linkedin.com, 2nd with chrome and ua.linkedin.com
    @Parameters({"browserType", "url"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType){

        if (browserType.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        if (browserType.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }

        else {
            System.out.println("Unsupported browser");
        }

       // System.setProperty("webdriver.gecko.driver", "/home/Vika/Downloads/geckodriver");


        webDriver.navigate().to("https://www.linkedin.com/");
        landingPage = new LinkedInLandingPage(webDriver);
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


}
