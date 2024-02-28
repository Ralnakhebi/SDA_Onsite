package HW.day06;

import org.checkerframework.checker.units.qual.A;
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

public class HW1 {



    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
    @Test
    public void test() {
        //Hw:1
        //Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        //Select Option 1 using index .
        select.selectByIndex(1);
        //Select Option 2 by value.
        select.selectByValue("2");

        //Select Option 1 value by visible text.
        select.selectByVisibleText("Option 2");
        //Print all dropdown value.
        boolean isOption2There =false;
        List<WebElement> options =select.getOptions();
        for (WebElement option : options){
            System.out.println("option: " + option.getText());
            if (option.getText().equals("Option 2")){
                isOption2There = true;
            }
        }

        //Verify the dropdown has Option 2 text.
        Assert.assertTrue("dropdown doesn't has Option 2 text",isOption2There);

        //Print first selected option.
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int size =select.getOptions().size();
        Assert.assertEquals("Expected Is Not Equal Actual",size,3);

    }
}
