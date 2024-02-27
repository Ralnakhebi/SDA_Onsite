package HW.day05;

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
import java.util.ArrayList;
import java.util.List;

public class Task2 {


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
            // Task 2:
        //     * breakout task: (in a separate class)
        //     * navigate to this url https://www.saucedemo.com/v1/inventory.html
        //     * add the first item you find to your cart
        //     * open your cart*
        //     * assert that the item name is correct inside the cart
        //     */
        driver.get("https://www.saucedemo.com/v1/inventory.html");
        List<WebElement>item= driver.findElements(By.xpath("//Button[starts-with(@class,'btn_primary')]"));
        item.get(0).click();
        Thread.sleep(1000);
        String itemName= driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement cart=driver.findElement(By.xpath("//*[starts-with(@class,'svg-inline--fa')]"));
        if(cart.isDisplayed()){
            cart.click();
        }
        WebElement cartItemName =driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        Thread.sleep(1000);
        System.out.println("itemName.getText() = " + cartItemName.getText());
        Assert.assertEquals(itemName,cartItemName.getText());



    }
}
