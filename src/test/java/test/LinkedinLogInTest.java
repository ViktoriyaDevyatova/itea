package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedInLoginPage;
import page.LinkedInHomePage;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 16.02.18.
 */
public class LinkedinLogInTest extends LinkedInBaseTest{

//    String initialPageTitle; - зберегти в пейджі і зробити свойствами (сетить и читать)
//    String initialPageUrl;

    @Test
    public void successfullyLogin () throws InterruptedException {

        String initialPageTitle = landingPage.getPageTitle();
        String  initialPageUrl = landingPage.getCurrentURL();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                                        "Login page name is not correct");

        LinkedInHomePage homePage = landingPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");

        Assert.assertTrue(homePage.isSignedIn(),"User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                                        "Page title did not change after login");
        Assert.assertNotEquals(homePage.getCurrentURL(), initialPageUrl,
                                        "URL after login did not change");

    }


    @DataProvider
    public Object[][] negatineTestCredentialsReturnToLanding() {
        return new Object[][]{
                {"", "123456"}};
          }


    @Test(dataProvider = "negatineTestCredentialsReturnToLanding")
    public void negativeLoginReturnToLanding (String email, String password) throws InterruptedException {

        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getCurrentURL();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page name is not correct");

        LinkedInLandingPage LandingPage = landingPage.loginAs(email, password);

      //  Assert.assertTrue(LandingPage.loginAs(),"User is signed in");

        Assert.assertEquals(LandingPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertEquals(LandingPage.getCurrentURL(), initialPageUrl,
                "URL after login did not change");

    }

    @DataProvider
    public Object[][] negatineTestCredentialsReturnToLogin() {
        return new Object[][]{
                {"test@ukr.net","123456", "Hmm, we don't recognize that email. Please try again.",
                        "Hmm, that's not the right password. Please try again or request a new one."},
        };
    }

    @Test(dataProvider = "negatineTestCredentialsReturnToLogin")
    public void negativeLoginReturnToLogin (String email, String password, String emailNotification, String passwordNotification) throws InterruptedException {

        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getCurrentURL();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page name is not correct");

        LinkedInLoginPage loginPage = landingPage.loginAs(email, password);

        Assert.assertTrue(loginPage.failedLogin(),"User is signed in");

        Assert.assertNotEquals(loginPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertNotEquals(loginPage.getCurrentURL(), initialPageUrl,
                "URL after login did not change");

        String actualEmailMessage = loginPage.getEmailMessage();
        String actualPassMessage = loginPage.gePassMessage();

        Assert.assertEquals(emailNotification, actualEmailMessage, "Actual and Expected mssages are not equel");
        Assert.assertEquals(passwordNotification, actualPassMessage, "Actual and Expected mssages are not equel");
    }
}
