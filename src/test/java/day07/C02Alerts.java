package day07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Alerts {
    /*
Alerts: There are two types of alerts on websites.
    1.HTML alerts: can be inspected by right-clicking and are similar to other web elements.
    2.JS alerts: cannot be inspected by right-clicking, thus different from other WebElement types.
     Interview question
        - How do you use (handle) alerts?
          It is used with driver.switchTo().alert().
          Commands:
          accept -> Clicks on OK or positive button
          dismiss -> Clicks on CANCEL or negative button
          getText -> Retrieves the alert message
          SendKeys -> Enters a message into the alert input field
 */
    /*
    Go to URL: http://demo.guru99.com/test/delete_customer.php
    Delete customer ID: 123
    Remove 2 alerts that appear.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //Delete customer ID: 123
        WebElement id = driver.findElement(By.name("cusid"));
        id.sendKeys("123", Keys.ENTER);
        Alert alert=driver.switchTo().alert();
        //Print the alert text.
        String massage = alert.getText();
        System.out.println("massage = " + massage);

        //Handling 2 alerts
        //driver.findElement(By.id(""));
        //Accepted the first alert, as if clicking OK
        alert.accept();

        //Print the Second alert text.
        String massage2 = alert.getText();
        System.out.println("massage = " + massage);

        //Accepted the second alert, as if clicking OK
        alert.accept();



    }
}

