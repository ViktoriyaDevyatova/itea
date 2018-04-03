package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInLandingPage;
import page.LinkedInLoginPage;
import page.LinkedInHomePage;

/**
 * Created by Vika on 16.02.18.
 */
public class LinkedinLogInTest extends LinkedInBaseTest{

//    String initialPageTitle; - зберегти в пейджі і зробити свойствами (сетить и читать)
//    String initialPageUrl;

    /**
     * provides correct credentials for the test successfullyLogin
     */
    @DataProvider
    public Object[][] successfullyLogin() {
        return new Object[][]{
                {"v.devyatova@ukr.net", "linkedkurdo2106"},
                {"V.DEVYATOVA@UKR.NET", "linkedkurdo2106"}
        };
    }


    /**
     *Test to verify successfull login to user account
     *  @param email - user email to login
     * @param password - user password to login
     * @throws InterruptedException
     */
    @Test(dataProvider = "successfullyLogin")
    public void successfullyLogin (String email, String password)  throws InterruptedException {

        String initialPageTitle = landingPage.getPageTitle();
        String  initialPageUrl = landingPage.getCurrentURL();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                                        "Login page name is not correct");

        LinkedInHomePage homePage = landingPage.loginAs(email, password);

        Assert.assertTrue(homePage.isLoaded(),"User is not signed in");

        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                                        "Page title did not change after login");
        Assert.assertNotEquals(homePage.getCurrentURL(), initialPageUrl,
                                        "URL after login did not change");

    }


    @DataProvider
    public Object[][] negatineTestCredentialsReturnToLanding() {
        return new Object[][]{
                {"", ""},
                {"", "linkedkurdo2106"},
                {"", "12345"},
                {"test.ukr.net", ""},
                {"v.devyatova@ukr.net", ""}
               };
          }


    /**
     *Test to verify negative login with incorrect credentials
     *  @param email - usincorrect email to login
     * @param password - incorrect password to login
     * @throws InterruptedException
     */

    @Test(dataProvider = "negatineTestCredentialsReturnToLanding")
    public void negativeLoginReturnToLanding (String email, String password) throws InterruptedException {

        String initialPageTitle = landingPage.getPageTitle();
        String initialPageUrl = landingPage.getCurrentURL();

        Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up",
                "Login page name is not correct");

        LinkedInLandingPage landingPage = this.landingPage.loginAs(email, password);

        Assert.assertTrue(landingPage.forgotPasswordButtonIsPresent(),"User is signed in");

        Assert.assertEquals(landingPage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");

        Assert.assertEquals(landingPage.getCurrentURL(), initialPageUrl,
                "URL after login did not change");

    }

    @DataProvider
    public Object[][] negatineTestCredentialsReturnToLogin() {
        return new Object[][]{
               {"test.ukr.net","123", "Please enter a valid email address.",
                        "The password you provided must have at least 6 characters."},
        };
    }

    /**
     *Test to verify negative login with incorrect credentials
     *  @param email - usincorrect email to login
     * @param password - incorrect password to login
     * @throws InterruptedException
     */

    @Test(dataProvider = "negatineTestCredentialsReturnToLogin")
    public void negativeLoginReturnToLoginIncorrectCred (String email, String password, String emailNotification, String passwordNotification) throws InterruptedException {

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
        String actualPassMessage = loginPage.getPassMessage();

        Assert.assertEquals(emailNotification, actualEmailMessage, "Actual and Expected meessages are not equel");
        Assert.assertEquals(passwordNotification, actualPassMessage, "Actual and Expected mssages are not equel");
    }

    @DataProvider
    public Object[][]negativeTestEmailReturnToLogin() {
        return new Object[][]{
                 {"v.devyatova@ukr.net", "123456", "Hmm, that's not the right password. Please try again or request a new one."},
                {"v.devyatova.ukr.net", "2106", "The password you provided must have at least 6 characters."}
        };
    }

    /**
     *Test to verify negative login with incorrect credentials
     * @param email - usincorrect email to login
     * @param password - incorrect password to login
     * @throws InterruptedException
     */

    @Test(dataProvider = "negativeTestEmailReturnToLogin")
    public void negativeLoginReturnToLoginIncorrectPass (String email, String password, String passwordNotification) throws InterruptedException {

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

        String actualPassMessage = loginPage.getPassMessage();

       Assert.assertEquals(passwordNotification, actualPassMessage, "Actual and Expected mssages are not equel");
    }

}
