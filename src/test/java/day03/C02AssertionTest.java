package day03;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C02AssertionTest {
      /*
    Go to Google homepage
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains google.
    2- Test if the title does not contain Facebook.
    3- Test that the Google logo appears on the page.
     */
      static WebDriver driver;
    @BeforeClass
    public static void BeforeClass(){
         driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         driver.get("https://google.com");
    }
    @AfterClass
    public static void AfterClass(){

        driver.quit();

    }


    @Test
    public void Test1(){

    }
    @Test
    public void Test2(){
       String title = driver.getTitle();
       assertFalse(title.contains("Facebook"));

    }
    @Test
    public void Test3(){

        WebElement logo= driver.findElement(By.className("lnXdpd"));
        assertTrue(logo.isDisplayed());

    }
}
