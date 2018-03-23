package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInLandingPage;
import page.LinkedInRequestPassResetPage;
import page.LinkedInRequestPassResetSubmitPage;

/**
 * Created by Vika on 23.03.18.
 */
public class LinkedInForgotPassTest extends LinkedInBaseTest{

    String email = "v.devyatova@ukr.net";

    @Test
    public void SuccessfullPassReset () throws InterruptedException {

        Assert.assertTrue(landingPage.failedLogin(), "Forgot password button is absent");

        LinkedInRequestPassResetPage requestPassResetPage = landingPage.forgotPassLinkClick();
        Assert.assertTrue(requestPassResetPage.isLoaded(), "requestPassResetPage is not loaded");

        LinkedInRequestPassResetSubmitPage passSubmitPage = requestPassResetPage.submitEmail(email);
        Assert.assertTrue(passSubmitPage.isLoaded(), "requestPassResetPage is not loaded");


    }
}
