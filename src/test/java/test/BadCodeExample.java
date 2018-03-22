package test;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Vika on 13.02.18.
 */
public class BadCodeExample {

    public static void main(String args[]) throws InterruptedException {
        //System.out.println("Hello World!");
        WebDriver webDriver = new FirefoxDriver();
        //webDriver.get("https://www.google.com.ua");
        webDriver.navigate().to("https://www.google.com.ua");
        String search = "Thailand".toLowerCase();
        webDriver.findElement(By.name("q")).sendKeys(search);
        webDriver.findElement(By.name("btnK")).click();
       //String titeles = webDriver.getTitle();
        //System.out.println("Search results:" + titeles);



        List<WebElement> listOfResults = webDriver.findElements(By.cssSelector("h3[class=\"r\"]"));
        for (WebElement result : listOfResults) {
            String checking = result.findElement(By.tagName("a")).getAttribute("href").toLowerCase();
            System.out.println("checking href: " + checking);
            Asserts.check(
                    checking.contains(search),
                    "Google producing wrong results!! Armaggeddon is coming!! we aware");

        }

        webDriver.close();
    }

}
