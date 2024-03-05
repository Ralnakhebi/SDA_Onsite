package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03RobotClass extends TestBase {

    @Test
    public void test() throws AWTException, InterruptedException {

        driver.get("https://www.ebay.com");
        Robot robot =new Robot();
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.click();

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //Thread.sleep(2000);
        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);
        robot.mouseWheel(30);

    }
}
