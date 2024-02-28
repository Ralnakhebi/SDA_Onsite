package HW.day06;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HW3 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //Task:3
        //Launch the browser.
        //Open "https://demoqa.com/select-menu".
        //Select the Standard Multi-Select using the element id.
        WebElement element = driver.findElement(By.id("cars"));
        Select select = new Select(element);
        //Verifying that the element is multi-select.
        Assert.assertTrue("The select doesn't allow multiple selector"
                ,select.isMultiple());

        //Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.deselectByIndex(2);
        //    Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        Thread.sleep(1000);
        select.deselectByValue("saab");
        //    Deselect all the options.
        select.deselectAll();
        //Select 'Saab' using value and deselect the same using value.
        //Deselect all the options.
        //Close the browser.
    }
}
