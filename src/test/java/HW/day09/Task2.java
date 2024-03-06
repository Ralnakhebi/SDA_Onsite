package HW.day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task2 extends TestBase {
    @Test
    public void test(){
        //Go to URL: https://rangeslider.js.org/
        driver.get("https://rangeslider.js.org/");
        //Shift 100 units to the right and 100 units to the left on the horizontal axis.

        By scroll = By.xpath("//div[@class='rangeslider__handle'][1]");
        WebElement scroller = driver.findElement(scroll);
        actions
                .dragAndDropBy(scroller,100,0)
                .pause(5)
                .dragAndDropBy(scroller,-100,0)
                .perform();
    }
}
