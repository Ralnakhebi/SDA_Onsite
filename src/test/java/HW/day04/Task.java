package HW.day04;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Task {


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-popup-blocking");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");


    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void browserOpened(){
        Assert.assertNotNull("Browser is not opened",driver);

    }
    @Test
    public void pageDisplayed(){
        String Link ="https://automationexercise.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String CurrentLink=driver.getCurrentUrl();
        Assert.assertEquals("Page not opening",Link,CurrentLink);

        WebElement LoginButton = driver.findElement(By.xpath("//*[contains(@class,'fa-lock')]"));


        //Assert.assertTrue("Login Button not Display",LoginButton.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement EmailField= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement PassField= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement Submit= driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        EmailField.sendKeys("sda@test.com");

        PassField.sendKeys("sdainclasstask");
        Submit.click();


        WebElement isLogin =driver.findElement(By.xpath("//b[normalize-space()='sda-automation']"));
        Assert.assertTrue("Failed to login",isLogin.isDisplayed());

    }

}
