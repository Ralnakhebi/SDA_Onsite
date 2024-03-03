package day04;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C04RadioButton {

    /*
  Go to URL: https://demoqa.com/
  Click on Elements.
  Click on Checkbox.
  Verify if Home checkbox is selected.
  Verify that "You have selected" is visible.

   */
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
        driver.get("https://facebook.com/");
        WebElement CreateNewAccountButton =driver.findElement(By.xpath("//*[starts-with(@id,'u_0_0_')]"));//*[contains(@id,'u_0_0_')]
        CreateNewAccountButton.click();
        WebElement firstName ;
        WebElement lastName;
        WebElement MobileNumber;
        WebElement PassWord;

        List<WebElement> RadioButtons= driver.findElements(By.name("sex"));


        for (WebElement Button: RadioButtons){
            Button.click();
            Assert.assertTrue(Button.isSelected());
            Thread.sleep(1000);
        }


    }
}
