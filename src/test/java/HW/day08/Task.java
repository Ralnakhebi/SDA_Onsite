package HW.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task extends TestBase {
    @Test
    public void test(){
        //Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        //Find the number of iframes on the page.
        List<WebElement> iframes =driver.findElements(By.tagName("iframe"));
        System.out.println("There are "+iframes.size()+" iframes ");
        String handle =driver.getWindowHandle();
        //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame(iframes.get(3));
        driver.findElement(By.xpath("//body//a//img")).click();
        //Exit the iframe and return to the main page.

        driver.switchTo().window(handle);
        driver.switchTo().defaultContent();
    }

}
