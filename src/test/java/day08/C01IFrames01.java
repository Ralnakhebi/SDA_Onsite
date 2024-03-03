package day08;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v121.indexeddb.model.Key;

import java.time.Duration;

public class C01IFrames01 {

        static WebDriver driver;

        @BeforeClass
        public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

        @Test
        public void test() {

            //Go to URL: https://the-internet.herokuapp.com/iframe
            driver.get("https://the-internet.herokuapp.com/iframe");
            //Verify the Bolded text contains "Editor"
            //  xpath : //h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']  , //h3  ,  tagName : h3
            WebElement boldText =driver.findElement(By.tagName("h3"));
            Assert.assertTrue(boldText.getText().contains("Editor"));
            WebElement bold =driver.findElement(By.xpath("//*[@title='Bold']"));
            bold.click();

            WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
            driver.switchTo().frame(iframe);

            //Locate the text box
            WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
            textBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
            //textBox.clear();
            textBox.sendKeys("SDA ..");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // To access the textBox web element, we need to switch to the iframe; otherwise, we will encounter a NoSuchElementExcepion.

            // Switching to the iframe

            // Using index (starts at 0)
            // Using id or name
            // Using webElement

            //WebElement textBox1 = driver.findElement(textBox);

        // Delete the text in the text box

        // Type "Hi everyone"


        // If we want to perform operations outside the iframe again
        // Brings it up by one level
            driver.switchTo().parentFrame();

        // Verify that the text "Elemental Selenium" is displayed on the page.
            WebElement text = driver.findElement(By.linkText("Elemental Selenium"));
            Assert.assertTrue(text.isDisplayed());
            //driver.quit();
    }

    }

