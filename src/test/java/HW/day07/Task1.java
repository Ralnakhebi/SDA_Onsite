package HW.day07;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task1 {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

    @Test
    public void test() {

        WebElement result =driver.findElement(By.id("result"));
        //click on "Click for JS Alert"
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();

        Alert alert =driver.switchTo().alert();
        alert.accept();

        //verify Accepting alert
        Assert.assertTrue(result.getText().contains("You successfully clicked an alert"));

        //click on "Click for JS Confirm"
        WebElement button2 =driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        //verify Accepting alert
        button2.click();
        alert.accept();
        Assert.assertTrue(result.getText().contains("You clicked: Ok"));
        //verify cancel alert
        button2.click();
        alert.dismiss();
        Assert.assertTrue(result.getText().contains("You clicked: Cancel"));


        //click on "Click for JS Prompt"
        WebElement button3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button3.click();

        alert.sendKeys("Hi ..");
        alert.accept();

        Assert.assertTrue(result.getText().contains("Hi .."));

    }
}
