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
import java.util.List;

public class C05DropDownExercise {

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
    public void test(){
        //Get all the options of the dropdown
        WebElement element =driver.findElement(By.id("oldSelectMenu"));
        Select select= new Select(element);
        List<WebElement> options =select.getOptions();
        //Options size
        System.out.println("options.size() = " + options.size());
        //Print all test
        for(WebElement option : options){
            //option will be printed
            System.out.println("option.getText() = " + option.getText());
        }
        //Verify the dropdown has option "Black"
        boolean isBlackOptionPresent = false;

        for (WebElement option : options) {
            if ("Black".equals(option.getText())) {
                isBlackOptionPresent = true;
                break;
            }
        }
        Assert.assertTrue("Dropdown does not have 'Black' option", isBlackOptionPresent);
        //Print FirstSelectedOptionTest
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        //Select option "Yellow"
        select.selectByVisibleText("Yellow");


    }
}
