package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 06.03.18.
 */
public class LinkedInHomePage extends LinkedInBasePage {

    /**
     *Find the webelement user icon
     */
    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    /**
     *Find the search ield
     */
    @FindBy(xpath = "//input[@placeholder='Search']")
    private  WebElement searchField;

    /**
     *Find the webelement search icon
     */
    @FindBy(xpath = "//*[@type='search-icon']")
    private  WebElement searchIcon;

    /**
     * Constructor of LinkedInHomePage class which takes WebDriver instance from LinkedInBasePage class
     * and initializes @FindBy LinkedInHomePage class WebElements via PageFactory
     * @param webDriver - webdriver instance
     */
    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *confirm if the page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded(){
        waitTillElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    /**
     *Enter and submit new password on SubmitNewwPass web page
     * @param searchWord - term for serch
     * @return new web page LinkedInSearchPage with search results
     */
    public LinkedInSearchPage searchByTerm(String searchWord) {
        searchField.sendKeys(searchWord);
        searchIcon.click();
        return new LinkedInSearchPage(webDriver);
    }


}
