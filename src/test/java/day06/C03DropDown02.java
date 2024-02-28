package day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03DropDown02 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        //locate WebElement with select tag
        WebElement element =driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));//--> cann't select mltiplue options
        // Create select object by passing select element into constructor
        Select select = new Select(element);
        //Select by index
        select.selectByIndex(3);
        Thread.sleep(1000);
        //Select by Value Purple
        select.selectByValue("4");
        Thread.sleep(1000);
        //Select by Value Red
        select.selectByValue("red");
        Thread.sleep(1000);
        //Select by Visible Text Purple
        select.selectByVisibleText("Purple");
        Thread.sleep(1000);

        WebElement element2 =driver.findElement(By.id("cars")); //--> can select mltiplue options
        Select select2 = new Select(element2);
        System.out.println("select.isMultiple() = " + select.isMultiple());
        System.out.println("select2.isMultiple() = " + select2.isMultiple());


    }
}
