package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInHomePage;
import page.LinkedInSearchPage;
import java.util.List;

/**
 * Created by Vika on 20.02.18.
 */
public class LinkedInSearchTest extends LinkedInBaseTest{

    @Test
    public void basicSearchTest() throws InterruptedException {

        String searchWord = "hr";

        LinkedInHomePage homePage = landingPage.loginAs("v.devyatova@ukr.net", "linkedkurdo2106");
        LinkedInSearchPage searchPage = homePage.searchByTerm(searchWord);
        List<String> results = searchPage.getResuls();

        Assert.assertEquals(results.size(), 10,
                "Expected size of results is not 10" );

        for (String result: results){
            Assert.assertTrue(result.toLowerCase().contains(searchWord),
                    "Search results does not contain HR in element" );
        }

    }

}
