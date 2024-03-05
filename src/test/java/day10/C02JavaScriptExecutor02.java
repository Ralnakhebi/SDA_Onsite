package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JScriptUtilities;
import utilities.TestBase;

public class C02JavaScriptExecutor02 extends TestBase {

    @Test
    public void test(){
        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");
        //Double click on the blue square at the bottom of the page
        driver.switchTo().frame(0);
        WebElement blueSquare = driver.findElement(By.xpath("//body/div"));
        // another xpath -->//span[.='Double click the block']/preceding-sibling::div
        JScriptUtilities.scrollIntoViewJS(driver,blueSquare);
        System.out.println("(\"background\") = " + blueSquare.getCssValue("background-color"));

        actions
                .doubleClick(blueSquare)
                        .perform();


        //Write the changed color on search box on the top of the page
        System.out.println("(\"background\") = " + blueSquare.getCssValue("background-color"));
        driver.switchTo().parentFrame();
        WebElement searchBox =driver.findElement(By.xpath("//form/input[@name='s']"));
        JScriptUtilities.scrollIntoViewJS(driver,searchBox);
        searchBox.sendKeys("Yellow");
        //Click "jQuery in Action" at the bottom of the page.
        WebElement jQueryInAction = driver.findElement(By.xpath("//ul[@class='books']/li/a[contains(@href,'manning')]"));
        // another xpath-->//a[contains(@href,'manning')]
        JScriptUtilities.clickElementByJS(driver,jQueryInAction);


    }


}
