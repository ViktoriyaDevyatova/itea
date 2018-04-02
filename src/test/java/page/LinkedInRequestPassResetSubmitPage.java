package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vika.GMailService;
import vika.GmailServiceImproved;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInRequestPassResetSubmitPage extends LinkedInBasePage {

    /**
     *Find the ResentLink button on the web page
     */
    @FindBy(xpath = "//a[@class= 'status-link btn-resend-link']")
    private WebElement resendLinkButton;


    public LinkedInRequestPassResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    /**
     *confirm if the page is loaded
     *  @return boolean expression
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = resendLinkButton.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }

    public  LinkedInChooseNewPassPage navigateToResetPassPage (String resetPassLink){
        webDriver.get(resetPassLink);
        return new LinkedInChooseNewPassPage(webDriver);
    }

    /**
     *Connects to gmail srvice and get email for password changing
     * @param messageToPartial - email subject
     * @return link to navigate for pass changing
     */
    public String getResetPassLink(String messageToPartial) {
        String messageSubjectPartial = "Vivien, here's the link to reset your password";
        String messageFromPartial = "security-noreply@linkedin.com";

        GMailService GMailService = new GMailService();
        String message = GMailService.waitForNewMessage(messageSubjectPartial, messageToPartial, messageFromPartial, 60);

      //  GmailServiceImproved gMailService = new GmailServiceImproved(messageSubjectPartial, messageToPartial, messageFromPartial, 20);
       // String message = gMailService.getResetMessage();

        String resetPasswordLink = org.apache.commons.lang3.StringUtils.substringBetween(message, "browser:", "This link").trim();
        return resetPasswordLink;
    }

}
