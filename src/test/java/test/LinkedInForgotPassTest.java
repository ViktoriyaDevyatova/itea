package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import vika.GMailService;
import vika.GmailServiceImproved;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInForgotPassTest extends LinkedInBaseTest {

    String email = "vivien.leeeeeee@gmail.com";
    String messageSubjectPartial = "Vivien, here's the link to reset your password";
    String messageToPartial = "vivien.leeeeeee@gmail.com";
    String messageFromPartial = "security-noreply@linkedin.com";
    String newPassword = "VD!kurdo2106";

    @Test
    public void SuccessfullPassReset() throws InterruptedException {
        GmailServiceImproved gMailService = new GmailServiceImproved(messageSubjectPartial, messageToPartial, messageFromPartial, 20);

        Assert.assertTrue(landingPage.forgotPasswordButtonIsPresent(), "Forgot password button is absent");

        LinkedInRequestPassResetPage requestPassResetPage = landingPage.forgotPassLinkClick();
        Assert.assertTrue(requestPassResetPage.isLoaded(), "requestPassResetPage is not loaded");


        LinkedInRequestPassResetSubmitPage passSubmitPage = requestPassResetPage.submitEmail(email);

        Assert.assertTrue(passSubmitPage.isLoaded(), "requestPassResetPage is not loaded");

        sleep(10000); //waiting for message
        String message = gMailService.getResetMessage();

        for (String elem : message.split("\n")) {
            if (elem.startsWith("https")) {
                System.out.println("we are following the link: " + elem);
                webDriver.get(elem);
            }
        }

        LinkedInResetPass resetPass = new LinkedInResetPass(webDriver);
        Assert.assertTrue(resetPass.isLoaded(), "resetPage is not loaded");

        LinkedINResetPassSubmit resetPassSubmit = resetPass.resetPassSubmit(newPassword);
        Assert.assertTrue(resetPassSubmit.isLoaded(), "resetSubmitPage is not loaded");

        LinkedInHomePage homePage = resetPassSubmit.navigateToHomePage();
        Assert.assertTrue(homePage.isSignedIn(), "You are not signed in");
    }
}

