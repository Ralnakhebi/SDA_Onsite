package day04;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C03CheckboxExercise {
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
        driver.quit();
    }


    @Test
    public void test(){
        // Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");
        // Click on Elements.
        //WebElement ElementsButton =driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='home-content']/div[@class='home-body']/div[@class='category-cards']/div[1]"));
        WebElement ElementsButton=driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]"));
        ElementsButton.click();
        // Click on Checkbox.
        WebElement CheckboxButton =driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
        CheckboxButton.click();
        String ExpectedUrl ="https://demoqa.com/checkbox";

        // Verify if Home checkbox is selected.
        Assert.assertEquals(ExpectedUrl,driver.getCurrentUrl());
        // Verify that "You have selected" is visible.
        WebElement Checkbox = driver.findElement(By.xpath("//span[@class='rct-title']"));
        if(!(Checkbox.isSelected())){
            Checkbox.click();
        }
        WebElement isSelected =driver.findElement(By.xpath("//span[normalize-space()='You have selected :']"));
        //div#result span -> CssSelector
        //div[@id='result']/span[1] -> Xpath

        Assert.assertTrue(isSelected.isDisplayed());
    }
}









