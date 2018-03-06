package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;

/**
 * Created by Vika on 01.03.18.
 */
public class LinkedInSignInPage {

    WebDriver webDriver;
    WebElement alertMessage;

    public LinkedInSignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private boolean initElements() throws InterruptedException {
        sleep(2000);
        alertMessage = webDriver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        return alertMessage.isDisplayed();
    }


}


