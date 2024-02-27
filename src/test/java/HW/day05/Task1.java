package HW.day05;

import org.checkerframework.checker.units.qual.N;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task1 {


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
        //driver.quit();
    }


    @Test
    public void test() throws InterruptedException {

        //Task 1:
        //Go to URL: https://demoqa.com/radio-button
        //Verify whether all 3 options given to the question can be selected.
        //When each option is selected, print the following texts on the console.
        JavascriptExecutor js=(JavascriptExecutor) driver;

        //javascriptExcutor.executerScr
        driver.get("https://demoqa.com/radio-button");
        Thread.sleep(10000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement YesButton =driver.findElement(By.id("yesRadio"));//"//*[@id='yesRadio']"
        WebElement ImpressiveButton =driver.findElement(By.id("impressiveRadio"));//*[@id='impressiveRadio']
        WebElement NoButton =driver.findElement(By.id("noRadio"));//"//*[@id='noRadio']"
        //js.executeScript("arguments[0].click()",YesButton);
        List<WebElement> RadioButtons=new ArrayList<>(3);
        RadioButtons.add(YesButton);
        RadioButtons.add(ImpressiveButton);
        RadioButtons.add(NoButton);

        for (WebElement Button: RadioButtons){
            js.executeScript("arguments[0].click()",Button);
            Assert.assertTrue("The Radio Button is not selected",Button.isSelected());
            System.out.println("The" + Button.getText()+" isSelected");

            Thread.sleep(1000);
        }


    }

}
