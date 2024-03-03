package HW.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;


public class Task3 extends TestBase {

    @Test
    public void test(){

        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        //Click on the windows - "WindowButton"
        String Handle1 =driver.getWindowHandle();
        driver.findElement(By.id("windowButton")).click();

        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
        Set<String> Handle2 =driver.getWindowHandles();
        String childHandle="";
        for (String handle : Handle2){
            if (!(handle.contains(Handle1))){
                childHandle=childHandle+ handle;
            }
        }
        System.out.println("childHandle = " + childHandle);
        driver.switchTo().window(childHandle);
        //Click on all the child windows.
        //Print the text present on all the child windows in the console.
        WebElement textInChild = driver.findElement(By.id("sampleHeading"));
        System.out.println("textInChild.getText() = " + textInChild.getText());
        //Print the heading of the parent window in the console.
        driver.switchTo().window(Handle1);
        System.out.println("Title of the parent window = " + driver.getTitle());

    }
}
