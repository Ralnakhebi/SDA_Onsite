package day08;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C03BaseClass extends TestBase {

    @Test
    public void test1(){
        driver.get("https://www.google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    @Test
    public void test2(){
        driver.get("https://clarusway.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    @Test
    public void test3(){
        driver.get("https://amazon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

}
