package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04FileUpload extends TestBase {

    @Test
    public void test(){
        By uploadId = By.id("file-upload");
        By uploadButton = By.id("file-submit");
        By Assest = By.xpath("//*[@class='example']");
        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Find the path of the file that you want to upload.
        String userDir = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        String fileName = "file1";
        String path = userDir+sep+fileName;
        System.out.println("path = " + path);

        //Click on Upload button.
        WebElement selectFile = driver.findElement(uploadId);
        selectFile.sendKeys(path);
        driver.findElement(uploadButton).click();
        String Result =driver.findElement(Assest).getText();
        //Verify the upload message.
        Assert.assertTrue(Result.contains("File Uploaded!"));

    }
}
