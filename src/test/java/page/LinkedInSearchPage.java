package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Vika on 13.03.18.
 */
public class LinkedInSearchPage {

    WebDriver webDriver;
    String elementText;


    public LinkedInSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    @FindBy(xpath = "//input[@placeholder='Search']")
//    private
//    WebElement searchField;
//
//    @FindBy(xpath = "//*[@type='search-icon']")
//    private
//    WebElement clickButton;

    public void waitTitleChange() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.titleContains("Search"));
    }

    public List<WebElement> listOfResults;



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
