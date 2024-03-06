package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C03FileDownload extends TestBase {

    @Test
    public void test(){
        //    Go to URL: https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement webElement = driver.findElement(By.partialLinkText("selenium-snapshot.png"));
        //    Download selenium-snapshot.png
        //webElement.click();
        //    Verify if the file downloaded successfully.
        String user = System.getProperty("user.home");
        String separator =System.getProperty("file.separator");
        String path=user+separator+"Downloads"+ separator+"selenium-snapshot.png";
        boolean exists = Files.exists(Path.of(path));
        System.out.println("exists = " + exists);
        Assert.assertTrue(exists);

    }

}
