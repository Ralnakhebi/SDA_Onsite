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


        //List<WebElement> a= driver.findElements(By.xpath("//span[contains(@class,'cusChoiceSpan')]"));
        //WebElement radi2 =driver.findElement(By.cssSelector("label[for='Radio_1']"));

        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // String contentBefore = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", radi2);
        //System.out.println("contentBefore = " + contentBefore);
        //String contentBefore = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";


        //List<WebElement> radios = driver.findElements(By.id("Radio-li"));

        //radios.get(0).click();
        //Assert.assertTrue(radios.get(0).isSelected());


        WebElement radio = driver.findElement(By.xpath("//input[@id='Radio_1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",radio);
        Assert.assertTrue("The Radio Button 1 is not selected",radio.isSelected());


        WebElement radio2 = driver.findElement(By.xpath("//input[@id='Radio_2']"));
        js.executeScript("arguments[0].click()",radio2);
        Assert.assertTrue("The Radio Button 2 is not selected",radio2.isSelected());
        System.out.println("radio.isSelected() = " + radio2.isSelected());

        WebElement radio3 = driver.findElement(By.xpath("//input[@id='Radio_3']"));
        js.executeScript("arguments[0].click()",radio3);
        Assert.assertTrue("The Radio Button 3 is not selected",radio3.isSelected());
        System.out.println("radio.isSelected() = " + radio3.isSelected());

        // Use JavaScript to retrieve the content added by ::after pseudo-element
        //String contentAfter = (String) js.executeScript("return window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');", radi2);
        //System.out.println("contentAfter = " + contentAfter);
//        System.out.println("background color is = " + radi2.getCssValue("background-color"));
//        radi2.click();
//        System.out.println("background color is = " + radi2.getCssValue("background-color"));



       // for (WebElement b : a){
            //System.out.println("radi2.getCssValue(\"background\") = " + a.getCssValue("background"));
         //   b.click();
            //System.out.println("radi2.getCssValue(\"background\") = " + a.getCssValue("background"));

            //Assert.assertTrue(b.isSelected());
        //}


        WebElement dropDown =driver.findElement(By.xpath("//span[contains(@class,'select2-selection__arrow')]"));

        dropDown.click();
        WebElement pick =driver.findElement(By.xpath("//input[@class='select2-search__field']"));
        pick.sendKeys("First Choice", Keys.ENTER);


        WebElement checkbox1 = driver.findElement(By.xpath("//label[@for='Checkbox_1']"));

        System.out.println("checkbox1.getCssValue(\"border-right-color\") = " + checkbox1.getCssValue("border-right-color"));

        js.executeScript("arguments[0].click()",checkbox1);

        System.out.println("checkbox1.getCssValue(\"border-right-color\") = " + checkbox1.getCssValue("border-right-color"));
        Assert.assertTrue("The checkbox1  is not selected",checkbox1.isSelected());

        List<WebElement> rating =driver.findElements(By.xpath("//a[@name='Rating']"));
        System.out.println("The color before the rating is " + rating.get(4).getCssValue("fill"));
        System.out.println("The color before the rating is " + rating.get(4).getCssValue("stroke"));

        js.executeScript("arguments[0].click()",rating.get(3));
        //Assert.assertTrue("There are no rating selected",rating.get(4).isSelected());

        System.out.println("The color after the rating is " + rating.get(3).getCssValue("fill"));
        System.out.println("The color after the rating is " + rating.get(3).getCssValue("stroke"));



        //WebElement countRaring =driver.findElement(By.xpath("//em[@id='Rating']"));
        String text = (String) js.executeScript("return document.getElementById('Rating').textContent;");
        System.out.println("count Raring: " + text);
        Assert.assertTrue(text.contains("4"));
        //class="ON"



        WebElement submit = driver.findElement(By.xpath("//button[@elname='submit'][1]"));

        //submit.click();
    }
}
