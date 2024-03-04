package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C01HandlesOfMultipleWindows extends TestBase {

    @Test
    public void test(){

        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        //        By tabElement = By.id("tabButton");
        //        By windElement = By.id("windowButton");
        //        By messageElement = By.id("messageWindowButton");
        //        By messageOnTab = By.id("sampleHeading");
        //
        //       // Go to URL: https://demoqa.com/browser-windows
        //        driver.get("https://demoqa.com/browser-windows");
        //
        //       // Click on all the child windows.
        //        driver.findElement(tabElement).click();
        //        driver.findElement(windElement).click();
        //        driver.findElement(messageElement).click();
        //
        //       // Print the text present on all the child windows in the console.
        //        Set<String> handles = driver.getWindowHandles();
        //        Iterator<String > itr = handles.iterator();
        //
        //        // Getting all handles one by one:
        //        String handleMain = itr.next();
        //        String handleTab = itr.next();
        //        String handleNewWind = itr.next();
        //        String handleWindMessage = itr.next();
        //
        //        //Print the heading of the parent window in the console.
        //        // To
        //        driver.switchTo().window(handleTab);
        //        System.out.println(driver.findElement(messageOnTab).getText());
        //
        //        driver.switchTo().window(handleNewWind);
        //        System.out.println(driver.findElement(messageOnTab).getText());

        //Click on the windows - "WindowButton"
        By tabElement = By.id("tabButton");
        By windowElement =By.id("windowButton");

        String Handle1 =driver.getWindowHandle();

        driver.findElement(windowElement).click();
        driver.findElement(tabElement).click();



        Set<String> Handle2 =driver.getWindowHandles();
        Iterator<String> itr = Handle2.iterator();
        List<String> li =new ArrayList<>();

        while (itr.hasNext()){
            li.add(itr.next());

        }
        System.out.println("li = " + li);


    }
}
