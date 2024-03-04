package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.Duration;

public class C04ActionsClass03 extends TestBase {

    @Test
    public void test(){
        By scroll2=By.xpath("//div[contains(@class,'range-slider')]/span[1]");
        By scroll = By.xpath("//div[@class='rangeslider__handle'][1]");
        //driver.get("https://rangeslider.js.org/");
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");
        //WebElement scroller = driver.findElement(scroll);
        WebElement scroller2 = driver.findElement(scroll2);
        actions
                .dragAndDropBy(scroller2,0,-32)
                .pause(Duration.ofSeconds(2))
                .dragAndDropBy(scroller2,0,32)
                .build()
                .perform();
    }
}
