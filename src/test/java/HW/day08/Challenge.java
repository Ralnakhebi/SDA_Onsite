package HW.day08;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Challenge extends TestBase {


    @Test
    public void test() throws InterruptedException {
        driver.get("https://clarusway.getlearnworlds.com/sda-test-registration-form");
        driver.switchTo().frame(0);
        By firstName=By.xpath("//li[@id='Name-li']//span[1]//input[1]");
        driver.findElement(firstName).sendKeys("Reemah");

        By lastName=By.xpath("//li[@id='Name-li']//span[2]//input[1]");
        driver.findElement(lastName).sendKeys("Alnakhebi");


        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(@id,'error-Name')]"));


        Assert.assertTrue(!errorMessage.isDisplayed());


        List<WebElement> a= driver.findElements(By.xpath("//span[contains(@class,'cusChoiceSpan')]"));
        WebElement radi2 =driver.findElement(By.cssSelector("label[for='Radio_1']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String contentBefore = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", radi2);
        System.out.println("contentBefore = " + contentBefore);
        radi2.click();
        Thread.sleep(1000);

        // Use JavaScript to retrieve the content added by ::after pseudo-element
        String contentAfter = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');", radi2);
        System.out.println("contentAfter = " + contentAfter);
//        System.out.println("background color is = " + radi2.getCssValue("background-color"));
//        radi2.click();
//        System.out.println("background color is = " + radi2.getCssValue("background-color"));



        for (WebElement b : a){
            //System.out.println("radi2.getCssValue(\"background\") = " + a.getCssValue("background"));
            b.click();
            //System.out.println("radi2.getCssValue(\"background\") = " + a.getCssValue("background"));



            //Assert.assertTrue(b.isSelected());
        }


        WebElement dropDown =driver.findElement(By.xpath("//span[contains(@class,'select2-selection__arrow')]"));

        dropDown.click();
        WebElement pick =driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        pick.sendKeys("First Choice", Keys.ENTER);


        List<WebElement> rating =driver.findElements(By.xpath("//a[@name='Rating']"));
        //rating.get(3).click();
        System.out.println("rating.isSelected() = " + rating.get(3).isSelected());
        //Assert.assertTrue("not selected:",rating.get(3).isSelected());

        WebElement submit = driver.findElement(By.xpath("//button[@elname='submit'][1]"));
        //submit.click();
    }
}
