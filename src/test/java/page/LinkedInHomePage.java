package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 06.03.18.
 */
public class LinkedInHomePage extends LinkedInBasePage {

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    public LinkedInHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSignedIn (){
        waitTillElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }
}
