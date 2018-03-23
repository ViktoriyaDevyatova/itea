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



    @Parameters({"browserType", "url"})
    @BeforeMethod
    public void beforeTest(@Optional("firefox") String browserType, @Optional("https://www.linkedin.com/") String url){

        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default:
                System.out.println("Unsupported browser");
                 break;
        }

        webDriver.navigate().to(url);
    //    webDriver.get("https://www.linkedin.com/");


        landingPage = new LinkedInLandingPage(webDriver);
    }

    @AfterMethod
    public void afterTest(){
        webDriver.close();
    }


}
