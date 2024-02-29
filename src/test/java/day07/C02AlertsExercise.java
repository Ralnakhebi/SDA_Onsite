package day07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02AlertsExercise {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {

        //driver.quit();
    }

    @Test
    public void test() {
        //Go to URL: https://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).click();

        //Click "Alert with OK" and click 'click the button to display an alert box:'
        Alert alert = driver.switchTo().alert();
        //Accept Alert(I am an alert box!) and print alert on console.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement OKAndCancel=driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
        OKAndCancel.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement ok= driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]"));
        ok.click();
        alert.accept();
        //Cancel Alert  (Press a Button !)
        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.partialLinkText("Textbox")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[contains(@class,'btn-info')]")).click();
        //alert.sendKeys(Keys.chord((Keys.CONTROL+"a")+Keys.BACK_SPACE));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        alert.sendKeys(Keys.chord(Keys.CLEAR));
        alert.sendKeys("Reema");
        alert.accept();

        //And then sendKeys «Bootcamp» (Please enter your name)
        //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
    }
}
