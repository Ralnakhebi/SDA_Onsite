package day04;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class C01RelativeLocators {

    static WebDriver driver;
    @BeforeClass
    public static void SetUp(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:www.linkedin.com/");

    }
    @Test
    public void task(){
        By emailField =RelativeLocator.with(By.id("session_key")).above(By.id("session_password"));
        driver.findElement(emailField).sendKeys("I did it :)");
    }
}
