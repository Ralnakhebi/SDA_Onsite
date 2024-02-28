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
import java.util.List;

public class HW2 {

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
        //Task:2
        // Launch the browser.
        // Open "https://demoqa.com/select-menu".
        driver.get("https://demoqa.com/select-menu");
        // Select the Old Style Select Menu using the element id.
        WebElement element =driver.findElement(By.id("oldSelectMenu"));
        Select select= new Select(element);

        // Print all the options of the dropdown.
        List<WebElement> options =select.getOptions();
        for(WebElement option : options){
            //option will be printed
            System.out.println("option: " + option.getText());
        }

        // Select 'Purple' using the index.
        select.selectByIndex(4);
        Thread.sleep(1000);
        Assert.assertTrue("The Purple option hasn't been selected",select.getOptions().get(4).isSelected());
        // After that, select 'Magenta' using visible text.
        select.selectByVisibleText("Magenta");
        Thread.sleep(1000);
        Assert.assertTrue("The Magenta option hasn't been selected",select.getOptions().get(9).isSelected());
        // Select an option using value.
        select.selectByValue("5");
        Thread.sleep(1000);
        Assert.assertTrue("The Black option hasn't been selected",select.getOptions().get(5).isSelected());
        // Close the browser.
    }
}
