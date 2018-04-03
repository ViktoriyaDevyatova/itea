package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInForgotPassTest extends LinkedInBaseTest {

    String email = "vivien.leeeeeee@gmail.com";
    String newPassword = "VD!kurdo2106";

    /**
     * Test to verify Forgot Password functionality
     * @throws InterruptedException
     */
    @Test
    public void SuccessfullPassReset() throws InterruptedException {

        Assert.assertTrue(landingPage.forgotPasswordButtonIsPresent(), "Forgot password button is absent");

        LinkedInRequestPassResetPage requestPassResetPage = landingPage.forgotPassLinkClick();
        sleep(10000);//manuall capcha
        Assert.assertTrue(requestPassResetPage.isLoaded(), "requestPassResetPage is not loaded");


        LinkedInRequestPassResetSubmitPage passSubmitPage = requestPassResetPage.submitEmail(email);
        String resetPasswordLink = passSubmitPage.getResetPassLink(email);
        sleep(20000); //manuall capcha

        Assert.assertTrue(passSubmitPage.isLoaded(), "requestPassResetPage is not loaded");

        LinkedInChooseNewPassPage chooseNewPassPage = passSubmitPage.navigateToResetPassPage(resetPasswordLink);
        Assert.assertTrue(chooseNewPassPage.isLoaded(), "resetPage is not loaded");

        LinkedInResetPassSuccessPage resetPassSubmit = chooseNewPassPage.submitNewPass(newPassword);
        Assert.assertTrue(resetPassSubmit.isLoaded(), "resetSubmitPage is not loaded");

        LinkedInHomePage homePage = resetPassSubmit.navigateToHomePage();
        Assert.assertTrue(homePage.isLoaded(), "You are not signed in");
    }
}

