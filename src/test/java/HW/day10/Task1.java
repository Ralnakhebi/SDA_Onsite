package HW.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JScriptUtilities;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Task1 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.youtube.com/");

        WebElement searchBox =driver.findElement(By.xpath("//input[@id='search']"));
        JScriptUtilities.clickElementByJS(driver,searchBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = 's.t.a.y. interstellar';", searchBox);
        WebDriverWait webDriverWait =new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();",searchButton );
        actions
                .doubleClick(searchButton)
                .perform();

        WebElement firstVideo = driver.findElement(By.id("video-title"));
        firstVideo.click();
//        List<WebElement> vid = driver.findElements(By.xpath("//ytd-section-list-renderer/div[@id='contents']"));
//        webDriverWait.until(ExpectedConditions.visibilityOf(vid.get(0)));
//
        actions
                .click(firstVideo)
                .perform();

    }

    @Test
    public void test2(){

        String search = "s.t.a.y. interstellar";
        //String vid = ""

        driver.get("https://www.youtube.com");
        WebElement sER = driver.findElement(By.xpath("//input[@id='search']"));

        sER.click();
        sER.sendKeys(search);
        sER.submit();

        WebElement yWR = driver.findElement(By.xpath("//yt-formatted-string[text()='"+search+"']"));

        yWR.click();

        Assert.assertTrue(driver.getTitle().contains(search));

    }
}
