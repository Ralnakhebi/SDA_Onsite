package HW.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Task2 extends TestBase {

    @Test
    public void test(){

        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //Verify the text: “Opening a new window”
        WebElement button = driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));

        WebElement textFristPage=driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']"));
        Assert.assertTrue(textFristPage.getText().contains("Opening a new window"));
        String handle = driver.getWindowHandle();

        //Verify the title of the page is “The Internet”
        String PageTitle = driver.getTitle();
        Assert.assertTrue(PageTitle.contains("The Internet"));

        //Click on the “Click Here” button
        button.click();
        //Verify the new window title is “New Window”
        Set<String> Handle2 =driver.getWindowHandles();
        String childHandle="";
        for (String handle1 : Handle2){
            if (!(handle1.contains(handle))){
                childHandle=childHandle+ handle1;
            }
        }
        System.out.println("childHandle = " + childHandle);
        driver.switchTo().window(childHandle);

        String PageTitle2 = driver.getTitle();
        System.out.println("PageTitle2 = " + PageTitle2);
        Assert.assertTrue(PageTitle2.contains("New Window"));
        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(handle);
    }
}
