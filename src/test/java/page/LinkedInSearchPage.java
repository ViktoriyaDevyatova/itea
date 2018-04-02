package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vika on 13.03.18.
 */
public class LinkedInSearchPage extends LinkedInBasePage {

    /**
     *Find the list with search results
     */
    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> listOfResults;

    /**
     *Finds the container with search results
     */
    @FindBy(xpath = "//div[@class= 'search-results top-page ember-view']")
    private WebElement resultsContainer;

    public LinkedInSearchPage(WebDriver webDriver) {
        super(webDriver);
    PageFactory.initElements(webDriver, this);
    }


    /**
     * Compare every element in the list with search therm
     * @return list of results
     */
    public List<String> getResuls() {

        waitTillElementIsVisible(resultsContainer, 5);
        List<String> resultStringList = new ArrayList();
        for (WebElement element:  listOfResults){
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
            String cardTitle = element.getText();
            resultStringList.add(cardTitle);
        }
        return resultStringList;
    }

    /**
     *confirm if the page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = resultsContainer.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }


    }
