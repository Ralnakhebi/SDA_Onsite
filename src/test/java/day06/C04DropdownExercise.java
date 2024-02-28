package day06;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04DropdownExercise {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        //    Launch the browser.
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        //    Close the browser.
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //    Open "https://demoqa.com/select-menu".
        driver.get("https://demoqa.com/select-menu");

        //    Select the Standard Multi-Select using the element id.
        WebElement element = driver.findElement(By.id("cars"));
        Select select=new Select(element);
        select.getAllSelectedOptions().get(2);

        //    Verifying that the element is multi-select.
        Assert.assertTrue(select.isMultiple());
        System.out.println("select.isMultiple() = " + select.isMultiple());

        //    Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.deselectByIndex(2);
        //    Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        Thread.sleep(1000);
        select.deselectByValue("saab");
        //    Deselect all the options.
        select.deselectAll();


    }
}
