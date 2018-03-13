package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Vika on 13.03.18.
 */
public class LinkedInSearchPage {

    WebDriver webDriver;


    public LinkedInSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitTitleChange() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.titleContains("Search"));
    }

    //sleep(5000);
    public List<WebElement> listOfResults = webDriver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));

    String elementText;

    public String checkOfSearchResult() {
        for (WebElement element : listOfResults) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
            elementText = element.getText().toLowerCase();
//            Assert.assertTrue(elementText.contains(searchWord),
//                    "Search result does not contain HR in element: " + element.getText());

        }

    return elementText;
    }
}
