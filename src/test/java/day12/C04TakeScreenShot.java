package day12;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04TakeScreenShot extends TestBase {

    // Go to linkedin.com.
    // Take Page ScreenShot.
    // Specific WebElement ScreenShot

    @Test
    public void takeFullPageScreenShot() throws IOException {
        driver.get("https://www.linkedin.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_m_ss").format(new Date());
        String separator = System.getProperty("file.separator");
        File destination = new File(System.getProperty("user.dir") + separator + "test-output" + separator + "screenshots" +separator+ "Linkedin"+date+".png");


        FileUtils.copyFile(source,destination);
    }

    @Test
    public void takeSpecificElementScreenshot() throws IOException {
        driver.get("https://www.linkedin.com");
        WebElement headline = driver.findElement(By.xpath("//*[@data-test-id='hero__headline']"));
        File source = headline.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String separator = System.getProperty("file.separator");

        File destination = new File(System.getProperty("user.dir") + separator+ "test-output" +separator+ "screenshots" + separator+ "Linkedin" +date+".png");

        FileUtils.copyFile(source,destination);

    }
}