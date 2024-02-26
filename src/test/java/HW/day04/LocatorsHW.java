package HW.day04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Scanner;

public class LocatorsHW {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void task() throws InterruptedException {
        String link= "https://www.temu.com/";
        driver.get(link);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
        WebElement SearchBox= driver.findElement(By.id("searchInput"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if(SearchBox.isDisplayed()){
            //SearchBox.click();
            //SearchBox.sendKeys("iphone");
        }


    }

}