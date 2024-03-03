package HW.day07;

import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {


        static WebDriver driver;

        @BeforeClass
        public static void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://the-internet.herokuapp.com/basic_auth");
        }

        @AfterClass
        public static void tearDown() {

            //driver.quit();
        }

        @Test
        public void test() {

            //username and password are admin
            //login
            driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            WebElement content =driver.findElement(By.id("content"));
            //verify
            Assert.assertTrue("user not able to login!!",
                    content.getText().contains("Congratulations! You must have the proper credentials"));
        }
    }
